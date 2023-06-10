package com.example.hsejavaexam.controller;

import com.example.hsejavaexam.api.ClientApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {
    @Override
    public void lend(long userId, long bookId) {

    }

    @Override
    public void returnBook(long bookId) {

    }
}
