package com.example.querydsl_ex.dto;

import com.example.querydsl_ex.constant.BookType;
import lombok.Builder;
import lombok.Data;

@Data
public class BookAndAuthorDto {

    private String bookName;

    private BookType bookType;

    private String name;

    private String email;

    @Builder
    public BookAndAuthorDto(String bookName, BookType bookType, String authorName, String authorEmail) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.name = authorName;
        this.email = authorEmail;
    }
}
