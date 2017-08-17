package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QOptionSet;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class OptionSetPredicate {

    public static Predicate findByCode(String optionSetCode) {
        QOptionSet optionSet = QOptionSet.optionSet;
        BooleanExpression boolExpression;
        boolExpression = optionSet.optionSetCode.eq(optionSetCode);
        boolExpression = boolExpression.and(optionSet.status.eq(Constants.STATUS.AVAILABLE));

        return boolExpression;
    }
}
