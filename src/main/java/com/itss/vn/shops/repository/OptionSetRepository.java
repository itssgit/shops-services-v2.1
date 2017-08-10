package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.OptionSet;
import com.itss.vn.shops.repository.custom.OptionSetRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface OptionSetRepository extends JpaRepository<OptionSet, Integer>, QueryDslPredicateExecutor<OptionSet>, OptionSetRepositoryCustom {
}
