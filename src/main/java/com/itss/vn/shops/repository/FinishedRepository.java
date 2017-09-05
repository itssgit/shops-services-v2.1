package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.Finished;
import com.itss.vn.shops.repository.custom.FinishedRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface FinishedRepository extends JpaRepository<Finished, Integer>, QueryDslPredicateExecutor<Finished>, FinishedRepositoryCustom {

    @Query("SELECT (CASE WHEN max(finishedId) IS NOT NULL THEN max(finishedId) ELSE 1 END) FROM Finished ")
    Integer getMaxId();
}
