package com.shoppingmall.domain.user.controller;

import com.shoppingmall.domain.user.dto.UserRequestDto;
import com.shoppingmall.domain.user.dto.UserResponseDto;
import com.shoppingmall.domain.user.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Getter
@Transactional
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.save(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getAddress(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(userResponseDto, HttpStatusCode.valueOf(201));
    }

    // 회원 탈퇴
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);

        return new ResponseEntity<>("탈퇴되었습니다", HttpStatusCode.valueOf(200));
    }

    // 회원 전체 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>>findAll() {
        List<UserResponseDto> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatusCode.valueOf(200));
    }

    // 회원 단일 조회
    @GetMapping("/{id}")

    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatusCode.valueOf(200));
    }
    
    // 회원 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(userService.update(id,requestDto.getName(), requestDto.getEmail(), requestDto.getAddress(), requestDto.getPassword()));
    }
}
