package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QOptionSetValue;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class OptionSetValuePredicate {

    public static Predicate findByOptionSetId(Integer optionSetId) {
        QOptionSetValue optionSetValue = QOptionSetValue.optionSetValue1;
        BooleanExpression boolExpression;
        boolExpression = optionSetValue.optionSetId.eq(optionSetId);
        boolExpression = boolExpression.and(optionSetValue.status.eq(Constants.STATUS.AVAILABLE));

        return boolExpression;
    }
}
