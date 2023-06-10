package com.example.hsejavaexam.controller;

import com.example.hsejavaexam.api.ClientApi;
import com.example.hsejavaexam.service.abstraction.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {
    private final Library library;

    @Override
    public void lend(String userId, long bookId) {
        library.lendBookToUser(bookId, userId);
        // TODO что-то сделать с userId
    }

    @Override
    public void returnBook(long bookId) {
        library.returnBook(bookId);
    }
}
