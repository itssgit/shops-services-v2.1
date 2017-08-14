package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QInventory;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class InventoryPredicate {

    public static Predicate findInventory(String inventoryCode, String inventoryName, Integer inventoryType, Integer inventoryStatus) {
        QInventory inventory = QInventory.inventory;
        BooleanExpression boolExpression;
        boolExpression = inventory.inventoryId.gt(0);
        boolExpression = boolExpression.and(inventory.status.eq(inventoryStatus));

        if (!inventoryCode.isEmpty()) {
            boolExpression = boolExpression.and(inventory.inventoryCode.like("%" + inventoryCode + "%"));
        }

        if (!inventoryName.isEmpty()) {
            boolExpression = boolExpression.and(inventory.inventoryName.like("%" + inventoryName + "%"));
        }

        if (inventoryType != -1) {
            boolExpression = boolExpression.and(inventory.inventoryType.eq(inventoryType));
        }



        return boolExpression;
    }
}
