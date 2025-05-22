package com.shoppingmall.domain.user.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private String name;

    private String email;

    private String address;

    public UserResponseDto(Long id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
