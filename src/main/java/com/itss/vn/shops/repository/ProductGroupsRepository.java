package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.ProductGroups;
import com.itss.vn.shops.repository.custom.ProductGroupsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductGroupsRepository extends JpaRepository<ProductGroups, Integer>, QueryDslPredicateExecutor<ProductGroups>, ProductGroupsRepositoryCustom {

    @Query("SELECT (CASE WHEN max(groupId) IS NOT NULL THEN max(groupId) ELSE 1 END) FROM ProductGroups ")
    Integer getMaxId();
}
