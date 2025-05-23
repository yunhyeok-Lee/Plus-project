package com.shoppingmall.domain.openapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hibernate.query.results.Builders.fetch;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenApiService {


    // api 정보 전체 조회
    public List<OpenApiDto> fetchByRating(int rating) {
        String ENDPOINT = "http://openapi.seoul.go.kr:8088/6d776b70796b696d35386973574841/json/ServiceInternetShopInfo/1/100";
        //   String SERVICE_KEY = "6d776b70796b696d35386973574841";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new LinkedMultiValueMap<>());
        ResponseEntity<Map> resultMap = restTemplate.exchange(ENDPOINT, HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return null;

//        ResponseEntity<OpenApiResponse> response = restTemplate.exchange(
//                ENDPOINT,
//                HttpMethod.GET,
//                null,
//                OpenApiResponse.class
//        );
//
//        List<OpenApiDto> allItems = response.getBody()
//                .getServiceInternetShopInfo()
//                .getRow();
//
//        // 필터링: 평점 기준
//        return allItems.stream()
//                .filter(dto -> dto.getTOT_RATINGPOINT() >= rating)
//                .collect(Collectors.toList());
//    }

    }
}


