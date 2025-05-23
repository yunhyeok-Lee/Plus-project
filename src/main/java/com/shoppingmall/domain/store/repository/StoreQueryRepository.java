package com.shoppingmall.domain.store.repository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@RequiredArgsConstructor
@Repository
public class StoreQueryRepository {
	private final JPAQueryFactory queryFactory;

}

