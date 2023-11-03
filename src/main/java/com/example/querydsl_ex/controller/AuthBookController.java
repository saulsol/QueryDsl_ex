package com.example.querydsl_ex.controller;

import com.example.querydsl_ex.dto.CreateAuthorDto;
import com.example.querydsl_ex.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
public class AuthBookController {

    private final AuthService authService;

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
}
