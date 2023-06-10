package com.example.hsejavaexam.controller;

import com.example.hsejavaexam.api.BooksApi;
import com.example.hsejavaexam.dto.BookInfoDto;
import com.example.hsejavaexam.dto.NewBookDto;
import com.example.hsejavaexam.dto.UpdateBookDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController implements BooksApi {
    @Override
    public List<BookInfoDto> getBooks() {
        return null;
    }

    @Override
    public long postBook(NewBookDto newBookDto) {
        return 0;
    }

    @Override
    public void putBook(long id, UpdateBookDto updateBookDto) {

    }

    @Override
    public void deleteBook(long id) {

    }
}
