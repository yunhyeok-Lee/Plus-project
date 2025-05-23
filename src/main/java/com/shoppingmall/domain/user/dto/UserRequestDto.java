package com.shoppingmall.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private Long id;
    private String name;
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,20}$",
            message = "비밀번호는 8~20자이며, 대문자, 소문자, 숫자를 포함해야 합니다.")
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
