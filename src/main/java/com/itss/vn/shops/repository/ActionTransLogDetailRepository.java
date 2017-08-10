package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.ActionTransLogDetail;
import com.itss.vn.shops.repository.custom.ActionTransLogDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ActionTransLogDetailRepository extends JpaRepository<ActionTransLogDetail, Integer>, QueryDslPredicateExecutor<ActionTransLogDetail>, ActionTransLogDetailRepositoryCustom {

}
