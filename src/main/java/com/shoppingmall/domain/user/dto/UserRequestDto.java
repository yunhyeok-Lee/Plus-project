package com.shoppingmall.domain.user.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;



    public UserRequestDto(Long id, String name, String email, String password, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }


}
