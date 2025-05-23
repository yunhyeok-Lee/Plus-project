package com.shoppingmall.domain.openapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.web.servlet.function.ServerResponse.badRequest;


@RestControllerAdvice
@Slf4j
public class OpenApiExceptionHandler {
    @ExceptionHandler(OpenApiException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> openApiExHandle(OpenApiException e) {
        log.error("오픈 API 예외 발생 : 핸들러 작동");
        return ResponseEntity.badRequest().build();
    }
}
