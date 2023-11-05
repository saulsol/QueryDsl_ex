package com.example.querydsl_ex.controller;

import com.example.querydsl_ex.dto.BookTypeDto;
import com.example.querydsl_ex.dto.CreateAuthorDto;
import com.example.querydsl_ex.dto.CreateBookDto;
import com.example.querydsl_ex.service.AuthService;
import com.example.querydsl_ex.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthBookController {

    private final AuthService authService;
    private final BookService bookService;

    @PostMapping("/newAuthor")
    public ResponseEntity<?> createAuthor(@RequestBody CreateAuthorDto createAuthorDto){
        return ResponseEntity.ok().body(authService.createAuthor(createAuthorDto));
    }

    // 10개씩 잘라서 리턴
    //http://localhost:8080/authorList?page=0
    @GetMapping("/authorList")
    public ResponseEntity<?> authorList(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok().body(authService.findAllAuthor(pageable));
    }

    @PostMapping("/newBook")
    public ResponseEntity<?> createBook(@RequestBody CreateBookDto createBookDto){
        return ResponseEntity.ok().body(bookService.createBook(createBookDto));
    }

    @PostMapping("/findByBookType")
    public ResponseEntity<?> findByBookType(@RequestBody BookTypeDto bookTypeDto){
      return ResponseEntity.ok().body(bookService.findByBookType(bookTypeDto));
    }

    @GetMapping("/findByBookName")
    public ResponseEntity<?> findByBookName(@RequestParam String bookName){
        return ResponseEntity.ok().body(bookService.findByBookName(bookName));
    }

}
