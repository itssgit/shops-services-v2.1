package com.itss.vn.shops.repository.predicate;


import com.itss.vn.shops.entity.q.QStockTransDetail;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class StockTransDetailPredicate {

    public static Predicate findByStockTransId(Integer stockTransId, Integer status) {
        QStockTransDetail stockTransDetail = QStockTransDetail.stockTransDetail;
        BooleanExpression boolExpression;
        boolExpression = stockTransDetail.stockTransId.eq(stockTransId);
        boolExpression = boolExpression.and(stockTransDetail.status.eq(status));

        return boolExpression;
    }
}
