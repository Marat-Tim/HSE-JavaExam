package com.example.hsejavaexam.repository;

import com.example.hsejavaexam.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
