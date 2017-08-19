package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QStockTransDetail;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class StockTransDetailPredicate {

    public static Predicate findByStockTransId(Integer stockTransId) {
        QStockTransDetail stockTransDetail = QStockTransDetail.stockTransDetail;
        BooleanExpression boolExpression;
        boolExpression = stockTransDetail.stockTransId.eq(stockTransId);
        boolExpression = boolExpression.and(stockTransDetail.status.eq(Constants.STATUS.AVAILABLE));

        return boolExpression;
    }
}
