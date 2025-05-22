package com.shoppingmall.domain.openapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class OpenApiDto {

    //오픈 api 서버에서 가져온 데이터를 우선적으로 받는 dto
    private String storeName;
    private String mailName;
    private String domainName;
    private String address;
    private String status;
    private Long phoneNumber;
    private Long rating;
    private LocalDateTime monitoredAt;


}
