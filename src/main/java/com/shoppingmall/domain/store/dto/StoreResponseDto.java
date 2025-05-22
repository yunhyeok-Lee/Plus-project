package com.shoppingmall.domain.store.dto;
import java.time.LocalDateTime;
import com.shoppingmall.domain.store.entity.Store;

 public class StoreResponseDto {

    public Long id;
    public String storeName;
    public String mallName;
    public String domainName;
    public String phoneNumber;
    public String address;
    public String status;
    public LocalDateTime monitoredAt;
    public String content;

    public StoreResponseDto(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.mallName = store.getMallName();
        this.domainName = store.getDomainName();
        this.phoneNumber = store.getPhoneNumber();
        this.address = store.getAddress();
        this.status = store.getStatus();
        this.monitoredAt = store.getMonitoredAt();
        this.content = store.getContent();
    }

 }
