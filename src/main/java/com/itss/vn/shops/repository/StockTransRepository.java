package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.StockTrans;
import com.itss.vn.shops.repository.custom.StockTransRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface StockTransRepository extends JpaRepository<StockTrans, Integer>, QueryDslPredicateExecutor<StockTrans>, StockTransRepositoryCustom {
}