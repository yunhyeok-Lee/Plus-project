package com.shoppingmall.domain.store.controller;


import com.shoppingmall.domain.store.dto.StoreRequestDto;
import com.shoppingmall.domain.store.dto.StoreResponseDto;
import com.shoppingmall.domain.store.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 생성자를 자동 생성해준다
@RequestMapping("/stores") // 클라이언트의 요청 URL을 특정 컨트롤러 메서드에 연결해주는 역할
@RestController // 데이터를 직접 json 같은 형태로 바꿔서 보내는 용도
public class StoreController {

    private final StoreService storeService; // java클래스 안에 선언된 멤버 변수를 의미한다.

    @PostMapping
    public ResponseEntity<StoreResponseDto> createStore(@RequestBody @Valid StoreRequestDto storeRequestDto) {
        StoreResponseDto response = storeService.save(storeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponseDto> findById(@PathVariable Long id) {
        StoreResponseDto response = storeService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StoreResponseDto>> findAll() {
        return ResponseEntity.ok(storeService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        storeService.deleteById(id);
        return ResponseEntity.ok("Success");
    }


    @PutMapping("/{id}")
    public ResponseEntity<StoreResponseDto> updateById(@PathVariable Long id,
                                                       @RequestBody StoreRequestDto storeRequestDto) {
        return ResponseEntity.ok(storeService.update(id, storeRequestDto));
    }
}



