package com.example.querydsl_ex.service;

import com.example.querydsl_ex.dto.CreateAuthorDto;
import com.example.querydsl_ex.entity.Author;
import com.example.querydsl_ex.repository.AuthorRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthorRepository authorRepository;
    private JPAQueryFactory jpaQueryFactory;

    public String createAuthor(CreateAuthorDto createAuthorDto){
        authorRepository.save(Author.toEntity(createAuthorDto));
        return createAuthorDto.getName()+"작가가 생성되었습니다";
    }

    public Page<Author> findAllAuthor(Pageable pageable){
        return authorRepository.findAll(pageable);
    }



}
