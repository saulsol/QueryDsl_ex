package com.example.querydsl_ex.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookType {
    HARD("딱딱한 책"), SOFT("부드러운 책");

    private final String value;

    @JsonCreator
    public static BookType from(String sub){
        for(BookType bookType : BookType.values()){
            if(bookType.getValue().equals(sub)){
                return bookType;
            }
        }
        return null;
    }
}
