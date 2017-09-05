package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.AttributeGroups;
import com.itss.vn.shops.repository.custom.AttributeGroupsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AttributeGroupsRepository extends JpaRepository<AttributeGroups, Integer>, QueryDslPredicateExecutor<AttributeGroups>, AttributeGroupsRepositoryCustom {

    @Query("SELECT (CASE WHEN max(attributeGroupId) IS NOT NULL THEN max(attributeGroupId) ELSE 1 END) FROM AttributeGroups ")
    Integer getMaxId();
}
