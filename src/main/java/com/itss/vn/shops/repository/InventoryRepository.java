package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.Inventory;
import com.itss.vn.shops.repository.custom.InventoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>, QueryDslPredicateExecutor<Inventory>, InventoryRepositoryCustom {

}
