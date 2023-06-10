package com.example.hsejavaexam.dto;

import com.example.hsejavaexam.entity.BookStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookInfoDto {
    private long id;

    private String name;

    private String author;

    private String description;

    private BookStatus status;
}
