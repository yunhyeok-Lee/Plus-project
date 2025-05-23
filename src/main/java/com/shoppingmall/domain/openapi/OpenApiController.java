package com.shoppingmall.domain.openapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OpenApiController {
    private final OpenApiService openApiService;
    @GetMapping("/open-api")
    public void getStoresInfo(){
        openApiService.fetchByRating(1);
    }


}
