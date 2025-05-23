package com.shoppingmall.domain.user.service;

import com.shoppingmall.domain.user.dto.UserLoginRequestDto;
import com.shoppingmall.domain.user.dto.UserLoginResponseDto;
import com.shoppingmall.domain.user.dto.UserRequestDto;
import com.shoppingmall.domain.user.dto.UserResponseDto;
import com.shoppingmall.domain.user.entity.User;
import com.shoppingmall.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository repository;
    private final UserRepository userRepository;

    // 회원가입

    @Transactional
    public UserResponseDto save(String name, String email, String address, String password) {
        // 생성
       User user = new User(name, email, address, password);

        //db에 저장

       user = userRepository.save(user);

        return new UserResponseDto(user.getId(), user.getName(), user.getAddress(), user.getEmail());
       
    }

    // 회원 탈퇴
    public void delete(Long id) {
        // 받아온 유저 아이디 조회
        User user = repository.findById(id).orElseThrow(
                () -> new RuntimeException("해당 유저를 찾을수 없습니다.")
        );
        // 조회한 유저 삭제
        repository.delete(user);
    }

    // 회원 전체 조회
    public List<UserResponseDto> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getAddress()))
                .toList();
    }

    // 회원 단일 조회
    public UserResponseDto findById(Long id) {

        User user = userRepository.findById(id).orElseThrow();

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getAddress());
    }

    // 회원 정보 수정
    @Transactional
    public UserResponseDto update(Long id, String name, String email, String address, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없습니다"));
        user.update(name, email, address, password);

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getAddress());
    }

    // 로그인
    public UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.findByEmail(userLoginRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("이메일주소가 틀렸습니다"));
        // !는 부정의 의미 비밀번호 불일치 검증
        if (!user.getPassword().equals(userLoginRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
        }
        return new UserLoginResponseDto(user.getId(), user.getName(), "로그인 성공");
    }
}
