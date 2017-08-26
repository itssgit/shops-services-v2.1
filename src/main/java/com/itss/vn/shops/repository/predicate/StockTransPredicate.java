package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QStockTrans;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Date;

public class StockTransPredicate {

    public static Predicate findByCode(String stockTransNo) {
        QStockTrans stockTrans = QStockTrans.stockTrans;
        BooleanExpression boolExpression;
        boolExpression = stockTrans.stockTransNo.eq(stockTransNo);
        boolExpression = boolExpression.and(stockTrans.status.eq(Constants.STATUS.AVAILABLE));

        return boolExpression;
    }

    public static Predicate findByCondition(String stockTransNo, String typeTrans, Date startDate, Date endDate) {
        QStockTrans stockTrans = QStockTrans.stockTrans;
        BooleanExpression boolExpression;
        boolExpression = stockTrans.status.eq(Constants.STATUS.AVAILABLE);

        if(!stockTransNo.isEmpty()) {
            boolExpression = boolExpression.and(stockTrans.stockTransNo.like("%" + stockTransNo + "%"));
        }

        if(!typeTrans.isEmpty()) {
            boolExpression = boolExpression.and(stockTrans.typeTrans.like("%" + typeTrans + "%"));
        }

        boolExpression = boolExpression.and(stockTrans.createdTime.after(startDate));
        boolExpression = boolExpression.and(stockTrans.createdTime.before(endDate));

        return boolExpression;
    }
}
