package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.Product;
import com.itss.vn.shops.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductRepository extends JpaRepository<Product, Integer>, QueryDslPredicateExecutor<Product>, ProductRepositoryCustom {

    @Query("SELECT (CASE WHEN max(productId) IS NOT NULL THEN max(productId) ELSE 1 END) FROM Product ")
    Integer getMaxId();
}
