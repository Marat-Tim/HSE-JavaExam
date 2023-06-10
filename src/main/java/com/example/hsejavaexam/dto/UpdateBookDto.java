package com.example.hsejavaexam.dto;

import com.example.hsejavaexam.entity.BookStatus;
import lombok.Data;

@Data
public class UpdateBookDto {
    private String name;

    private String author;

    private String description;

    private BookStatus status;
}
