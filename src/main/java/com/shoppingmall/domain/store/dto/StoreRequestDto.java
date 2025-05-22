package com.shoppingmall.domain.store.dto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.security.PublicKey;
import java.time.LocalDateTime;

@Getter
public class StoreRequestDto {

    @NotEmpty

    private String storeName;
    private String mallName;
    private String domainName;
    private String phoneNumber;
    private String address;
    private String status;
    private LocalDateTime monitoredAt;
    private String content;

}


