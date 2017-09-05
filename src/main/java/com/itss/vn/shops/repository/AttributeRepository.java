package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.Attribute;
import com.itss.vn.shops.repository.custom.AttributeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AttributeRepository extends JpaRepository<Attribute, Integer>, QueryDslPredicateExecutor<Attribute>, AttributeRepositoryCustom {

    @Query("SELECT (CASE WHEN max(attributeId) IS NOT NULL THEN max(attributeId) ELSE 1 END) FROM Attribute ")
    Integer getMaxId();
}
