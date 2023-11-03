package com.example.querydsl_ex.entity;

import com.example.querydsl_ex.constant.BookType;
import com.example.querydsl_ex.dto.CreateBookDto;
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

    public static Book toEntity(CreateBookDto createBookDto, Author author){
        Book newBook = new Book();
        newBook.bookName = createBookDto.getBookName();
        newBook.bookType = createBookDto.getBookType();
        newBook.author = author;

        return newBook;
    }

}
