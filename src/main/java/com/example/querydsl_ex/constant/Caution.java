package com.example.querydsl_ex.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Caution {

    TOO_HARD("책 표지가 엄청 딱딱하니깐 조심하세요."),
    TOO_SOFT("책 종이가 쉽게 찢어지니깐 조심하세요.");

    private final String value;   

}
