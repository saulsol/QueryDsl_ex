package com.example.querydsl_ex.repository;

import com.example.querydsl_ex.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
