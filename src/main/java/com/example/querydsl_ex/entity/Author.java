package com.example.querydsl_ex.entity;

import com.example.querydsl_ex.dto.CreateAuthorDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    private String name;

    private String email;
    @Builder
    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static Author toEntity(CreateAuthorDto createAuthorDto){

        return Author.builder()
                .email(createAuthorDto.getEmail())
                .name(createAuthorDto.getName())
                .build();
    }

}
