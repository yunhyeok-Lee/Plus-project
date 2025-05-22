package com.shoppingmall.domain.store.service;

import com.shoppingmall.domain.store.dto.StoreRequestDto;
import com.shoppingmall.domain.store.dto.StoreResponseDto;
import com.shoppingmall.domain.store.entity.Store;
import com.shoppingmall.domain.store.repository.StoreRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional

public class StoreService {

    private final StoreRepository storeRepository;


    @Transactional
    public StoreResponseDto save(StoreRequestDto dto) {

        Store store = new Store(dto.getStoreName(), dto.getMallName(), dto.getDomainName(),
                dto.getPhoneNumber(), dto.getAddress(), dto.getStatus(), dto.getMonitoredAt(), dto.getContent());

        store = storeRepository.save(store);

        return new StoreResponseDto(store);
    }

    public StoreResponseDto findById(Long id) {
        Store store = storeRepository.findStoreById(id);

        return new StoreResponseDto(store);
    }

    public List<StoreResponseDto> findAll() {
        List<Store> stores = storeRepository.findAll(); // 1
        List<StoreResponseDto> storeResponses = new ArrayList<>(); // 1

        for (Store store : stores) {
            storeResponses.add(new StoreResponseDto(store));
        }
        return storeResponses;
    }

    public void deleteById(Long id) {
        Store store = storeRepository.findStoreById(id);
        storeRepository.delete(store);
    }

    @Transactional
    public StoreResponseDto update(Long id, String content) {
        Store store = storeRepository.findById(id)
                .orElseThrow();
        store.update(content);

        return new StoreResponseDto(store);

    }
}