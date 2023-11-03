package com.example.querydsl_ex.service;

import com.example.querydsl_ex.repository.BookRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final JPAQueryFactory jpaQueryFactory;




}
