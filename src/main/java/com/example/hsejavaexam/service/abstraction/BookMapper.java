package com.example.hsejavaexam.service.abstraction;

import com.example.hsejavaexam.dto.BookInfoDto;
import com.example.hsejavaexam.dto.NewBookDto;
import com.example.hsejavaexam.dto.UpdateBookDto;
import com.example.hsejavaexam.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity mapNewBookToEntity(NewBookDto newBookDto);

    BookEntity mapUpdateBookToEntity(UpdateBookDto updateBookDto);

    BookInfoDto mapEntityToBookInfo(BookEntity bookEntity);
}
