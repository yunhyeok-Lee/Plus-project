package com.shoppingmall.domain.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    // 이메일 주소 검증
    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleCustomException(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("입력오류" + exception.getMessage());
    }
    // 비밀번호 검증
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body("입력 오류 : " + exception.getMessage());
    }
}
