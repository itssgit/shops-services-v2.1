package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.ProductGroups;
import com.itss.vn.shops.entity.ProductGroupsDetail;
import com.itss.vn.shops.repository.custom.ProductGroupsDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductGroupsDetailRepository extends JpaRepository<ProductGroupsDetail, Integer>, QueryDslPredicateExecutor<ProductGroups>, ProductGroupsDetailRepositoryCustom {

    @Query("SELECT (CASE WHEN max(id) IS NOT NULL THEN max(id) ELSE 1 END) FROM ProductGroupsDetail ")
    Integer getMaxId();
}
