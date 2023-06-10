package com.example.hsejavaexam.api;

import com.example.hsejavaexam.dto.BookInfoDto;
import com.example.hsejavaexam.dto.NewBookDto;
import com.example.hsejavaexam.dto.UpdateBookDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
public interface BooksApi {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BookInfoDto> getBooks();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    long postBook(@RequestBody NewBookDto newBookDto);

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    void putBook(@RequestParam long id, @RequestBody UpdateBookDto updateBookDto);

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    void deleteBook(@RequestParam long id);
}
