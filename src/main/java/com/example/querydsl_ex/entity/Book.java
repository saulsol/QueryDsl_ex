package com.example.querydsl_ex.entity;

import com.example.querydsl_ex.constant.BookType;
import com.example.querydsl_ex.dto.CreateBookDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    private String bookName;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @Builder
    public Book(String bookName, BookType bookType, Author author) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
    }

    public static Book toEntity(CreateBookDto createBookDto, Author author){
        return Book.builder()
                .bookName(createBookDto.getBookName())
                .bookType(createBookDto.getBookType())
                .author(author)
                .build();
    }

}
