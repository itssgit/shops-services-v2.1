package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.OptionSetValue;
import com.itss.vn.shops.repository.custom.OptionSetValueRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface OptionSetValueRepository  extends JpaRepository<OptionSetValue, Integer>, QueryDslPredicateExecutor<OptionSetValue>, OptionSetValueRepositoryCustom {
}
