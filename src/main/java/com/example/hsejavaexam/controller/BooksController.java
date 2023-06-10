package com.example.hsejavaexam.controller;

import com.example.hsejavaexam.api.BooksApi;
import com.example.hsejavaexam.dto.BookInfoDto;
import com.example.hsejavaexam.dto.NewBookDto;
import com.example.hsejavaexam.dto.UpdateBookDto;
import com.example.hsejavaexam.service.abstraction.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksController implements BooksApi {
    private final Library library;

    @Override
    public List<BookInfoDto> getBooks() {
        return library.getAllBooks();
    }

    @Override
    public long postBook(NewBookDto newBookDto) {
        return library.addNewBook(newBookDto);
    }

    @Override
    public void putBook(long id, UpdateBookDto updateBookDto) {
        library.updateBook(id, updateBookDto);
    }

    @Override
    public void deleteBook(long id) {
        library.deleteBook(id);
    }
}
