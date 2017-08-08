package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.ActionTransLog;
import com.itss.vn.shops.repository.custom.ActionTransLogRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ActionTransLogRepository extends JpaRepository<ActionTransLog, Integer>, QueryDslPredicateExecutor<ActionTransLog>, ActionTransLogRepositoryCustom {

}
