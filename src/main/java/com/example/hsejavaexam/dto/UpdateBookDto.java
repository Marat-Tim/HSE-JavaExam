package com.example.hsejavaexam.dto;

import com.example.hsejavaexam.domain.BookStatus;
import lombok.Data;

@Data
public class UpdateBookDto {
    private String name;

    private String author;

    private String description;
}
