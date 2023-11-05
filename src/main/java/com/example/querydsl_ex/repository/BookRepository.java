package com.example.querydsl_ex.repository;

import com.example.querydsl_ex.dto.BookAndAuthorDto;
import com.example.querydsl_ex.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookName(String bookName);

    @Query("SELECT NEW com.example.querydsl_ex.dto.BookAndAuthorDto(b.bookName, b.bookType, a.name, a.email)"+
        "FROM Book b JOIN Author a ON b.author.authorId = a.authorId")
    BookAndAuthorDto findByBookNameDto(String bookName);
    // 성공
}
