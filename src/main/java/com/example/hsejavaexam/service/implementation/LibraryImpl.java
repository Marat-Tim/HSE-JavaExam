package com.example.hsejavaexam.service.implementation;

import com.example.hsejavaexam.dto.BookInfoDto;
import com.example.hsejavaexam.dto.NewBookDto;
import com.example.hsejavaexam.dto.UpdateBookDto;
import com.example.hsejavaexam.entity.BookEntity;
import com.example.hsejavaexam.domain.BookStatus;
import com.example.hsejavaexam.repository.BookRepository;
import com.example.hsejavaexam.service.abstraction.BookMapper;
import com.example.hsejavaexam.service.abstraction.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LibraryImpl implements Library {
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public long addNewBook(NewBookDto newBookDto) {
        BookEntity book = bookMapper.mapNewBookToEntity(newBookDto);
        book.setStatus(BookStatus.IN_STOCK);
        BookEntity savedBook = bookRepository.save(book);
        return savedBook.getId();
    }

    @Override
    public void updateBook(long id, UpdateBookDto updateBookDto) {
        Optional<BookEntity> oldBook = bookRepository.findById(id);
        if (oldBook.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Книги с таким id не существует");
        }
        BookEntity book = bookMapper.mapUpdateBookToEntity(updateBookDto);
        book.setStatus(oldBook.get().getStatus());
        book.setId(id);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Книги с таким id не существует");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookInfoDto> getAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(bookMapper::mapEntityToBookInfo).toList();
    }

    @Override
    public void lendBookToUser(long id, String userId) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Книги с таким id не существует"));
        if (book.getStatus() == BookStatus.ISSUED) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Данная книга уже выдана");
        }
        book.setStatus(BookStatus.ISSUED);
        book.setUserId(userId);
        bookRepository.save(book);
    }

    @Override
    public void returnBook(long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Книги с таким id не существует"));
        book.setStatus(BookStatus.IN_STOCK);
        bookRepository.save(book);
    }
}
