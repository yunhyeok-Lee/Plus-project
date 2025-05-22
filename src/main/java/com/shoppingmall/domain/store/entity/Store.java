package com.shoppingmall.domain.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;
    private String mallName;
    private String domainName;
    private String phoneNumber;
    private String address;
    private String status;
    private LocalDateTime monitoredAt;
    private String content;

    public Store(String storeName, String mallName, String domainName,
                 String phoneNumber, String address, String status, LocalDateTime monitoredAt, String content) {

        this.storeName = storeName;
        this.mallName = mallName;
        this.domainName = domainName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.monitoredAt = monitoredAt;
        this.content = content;
    }
}
