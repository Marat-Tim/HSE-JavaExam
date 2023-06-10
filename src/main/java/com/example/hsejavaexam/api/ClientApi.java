package com.example.hsejavaexam.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ClientApi {
    @PostMapping("/lend")
    @ResponseStatus(HttpStatus.OK)
    void lend(@RequestParam long userId, @RequestParam long bookId);

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    void returnBook(@RequestParam long bookId);

}
