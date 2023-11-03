package com.example.querydsl_ex.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookType {
    HARD("딱딱한 책"), SOFT("부드러운 책");

    // HARD : 객체 이름
    //"딱딱한 책" : 객체안에 담긴 값

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
