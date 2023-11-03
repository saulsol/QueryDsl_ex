package com.example.querydsl_ex.dto;

import com.example.querydsl_ex.constant.BookType;
import lombok.Data;

@Data
public class CreateBookDto {
    private String bookName;
    private BookType bookType;
    private Long authorId;
}
