package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.FinishedDetail;
import com.itss.vn.shops.repository.custom.FinishedDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface FinishedDetailRepository extends JpaRepository<FinishedDetail, Integer>, QueryDslPredicateExecutor<FinishedDetail>, FinishedDetailRepositoryCustom {

    @Query("SELECT (CASE WHEN max(id) IS NOT NULL THEN max(id) ELSE 1 END) FROM FinishedDetail ")
    Integer getMaxId();
}
