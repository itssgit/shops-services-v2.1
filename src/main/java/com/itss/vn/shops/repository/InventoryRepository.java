package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.Inventory;
import com.itss.vn.shops.repository.custom.InventoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>, QueryDslPredicateExecutor<Inventory>, InventoryRepositoryCustom {

    @Query("SELECT (CASE WHEN max(inventoryId) IS NOT NULL THEN max(inventoryId) ELSE 1 END) FROM Inventory ")
    Integer getMaxId();
}
