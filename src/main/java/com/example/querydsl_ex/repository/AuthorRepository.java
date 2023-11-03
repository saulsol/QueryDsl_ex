package com.example.querydsl_ex.repository;

import com.example.querydsl_ex.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
