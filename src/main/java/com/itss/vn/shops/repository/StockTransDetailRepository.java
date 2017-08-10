package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.StockTransDetail;
import com.itss.vn.shops.repository.custom.StockTransDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface StockTransDetailRepository extends JpaRepository<StockTransDetail, Integer>, QueryDslPredicateExecutor<StockTransDetail>, StockTransDetailRepositoryCustom {
}
