package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QInventory;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class InventoryPredicate {

    public static Predicate findInventory(String inventoryCode, String inventoryName, Integer inventoryType) {
        QInventory inventory = QInventory.inventory;
        BooleanExpression boolExpression;
        boolExpression = inventory.inventoryId.gt(0);
        boolExpression = boolExpression.and(inventory.status.eq(Constants.STATUS.AVAILABLE));

        if (inventoryCode != null && !inventoryCode.isEmpty()) {
            boolExpression = boolExpression.
                    andAnyOf(inventory.inventoryCode.like("%" + inventoryCode + "%"));
        }

        if (inventoryName != null && !inventoryName.isEmpty()) {
            boolExpression = boolExpression.
                    andAnyOf(inventory.inventoryName.like("%" + inventoryName + "%"));
        }

        if (inventoryType != null) {
            boolExpression = boolExpression.
                    andAnyOf(inventory.inventoryType.eq(inventoryType));
        }


        return boolExpression;
    }
}
