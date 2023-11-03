package com.example.querydsl_ex.entity;

import com.example.querydsl_ex.dto.CreateAuthorDto;
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

    public static Author toEntity(CreateAuthorDto createAuthorDto){
        Author newAuthor = new Author();
        newAuthor.name = createAuthorDto.getName();
        newAuthor.email = createAuthorDto.getEmail();

        return newAuthor;
    }

}
