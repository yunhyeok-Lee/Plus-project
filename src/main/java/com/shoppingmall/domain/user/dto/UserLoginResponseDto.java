package com.shoppingmall.domain.user.dto;

import lombok.Getter;

@Getter
public class UserLoginResponseDto {

    private Long id;
    private String name;
    private String message;

    public UserLoginResponseDto(Long id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }
}
