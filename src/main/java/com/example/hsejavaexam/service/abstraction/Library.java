package com.example.hsejavaexam.service.abstraction;

import com.example.hsejavaexam.dto.BookInfoDto;
import com.example.hsejavaexam.dto.NewBookDto;
import com.example.hsejavaexam.dto.UpdateBookDto;

import java.awt.print.Book;
import java.util.List;

public interface Library {
    long addNewBook(NewBookDto newBookDto);

    void updateBook(long id, UpdateBookDto updateBookDto);

    void deleteBook(long id);

    List<BookInfoDto> getAllBooks();

    void lendBookToUser(long id, String userId);

    void returnBook(long id);
}
