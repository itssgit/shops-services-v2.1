package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QStockTrans;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class StockTransPredicate {

    public static Predicate findByCode(String stockTransNo) {
        QStockTrans stockTrans = QStockTrans.stockTrans;
        BooleanExpression boolExpression;
        boolExpression = stockTrans.stockTransNo.eq(stockTransNo);
        boolExpression = boolExpression.and(stockTrans.status.eq(Constants.STATUS.AVAILABLE));

        return boolExpression;
    }
}
