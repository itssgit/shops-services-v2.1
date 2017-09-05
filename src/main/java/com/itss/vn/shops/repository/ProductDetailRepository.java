package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.ProductDetail;
import com.itss.vn.shops.repository.custom.ProductDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer>, QueryDslPredicateExecutor<ProductDetail>, ProductDetailRepositoryCustom {

    @Query("SELECT (CASE WHEN max(id) IS NOT NULL THEN max(id) ELSE 1 END) FROM ProductDetail ")
    Integer getMaxId();
}
