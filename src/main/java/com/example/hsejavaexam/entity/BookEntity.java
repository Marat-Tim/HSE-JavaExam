package com.example.hsejavaexam.entity;

import com.example.hsejavaexam.domain.BookStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String name;

    private String author;

    @Column(length = 50)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name = "user_id")
    private String userId;
}
