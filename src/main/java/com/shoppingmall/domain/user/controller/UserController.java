package com.shoppingmall.domain.user.controller;

import com.shoppingmall.domain.user.dto.UserLoginRequestDto;
import com.shoppingmall.domain.user.dto.UserLoginResponseDto;
import com.shoppingmall.domain.user.dto.UserRequestDto;
import com.shoppingmall.domain.user.dto.UserResponseDto;
import com.shoppingmall.domain.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponseDto> signUp(@Valid @RequestBody UserRequestDto requestDto) {
        // UserService에 전달해서 회원가입을 처리하고, 그 결과로 생성된 유저 정보를 담은 DTO를 반환받음
        UserResponseDto userResponseDto = userService.save(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getAddress(),
                requestDto.getPassword()
        );
        // http 응답 생성
        return new ResponseEntity<>(userResponseDto, HttpStatusCode.valueOf(201));
    }

    // 회원 탈퇴
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        // 서비스에서 실제 삭제 로직 수행
        userService.delete(id);

        return new ResponseEntity<>("탈퇴되었습니다", HttpStatusCode.valueOf(200));
    }

    // 회원 전체 조회
    @GetMapping
    // HTTP 응답 본문에 UserResponseDto 리스트를 담아서 반환
    public ResponseEntity<List<UserResponseDto>>findAll() {
        // UserService의 findAll() 메서드를 호출하여,
        // DB에서 모든 사용자 정보를 조회하고 이를 UserResponseDto로 변환한 결과를 리스트로 받음
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

    // 로그인
    @PostMapping("/login")

    public ResponseEntity<UserLoginResponseDto> login(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto, HttpSession session) {
        UserLoginResponseDto userLoginResponseDto = userService.login(userLoginRequestDto);
        
        // 세션에 로그인 사용자 정보 저장
        session.setAttribute("loginUser", userLoginResponseDto);

        return ResponseEntity.ok(userLoginResponseDto);
    }

    // 로그아웃
    @PostMapping("/logout")

    public ResponseEntity<String> logout(HttpSession session) {
        // 세션 삭제
        session.invalidate();
        return ResponseEntity.ok("로그아웃");
    }
}
