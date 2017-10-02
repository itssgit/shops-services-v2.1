package com.itss.vn.shops.repository.predicate;


import com.itss.vn.common.constant.Constants;
import com.itss.vn.shops.entity.q.QProductGroups;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class ProductGroupsPredicate {

    public static Predicate findByCode(String groupCode) {
        QProductGroups productGroups = QProductGroups.productGroups;
        BooleanExpression boolExpression;
        boolExpression = productGroups.groupCode.eq(groupCode);
        boolExpression = boolExpression.and(productGroups.status.eq(Constants.STATUS.AVAILABLE));

        return boolExpression;
    }

    public static Predicate findByCondition(String groupsCode, Integer status, String groupsName) {
        QProductGroups productGroups = QProductGroups.productGroups;
        BooleanExpression boolExpression;
        boolExpression = productGroups.status.eq(status);

        if (!groupsCode.isEmpty()) {
            boolExpression = boolExpression.and(productGroups.groupCode.like("%" + groupsCode + "%"));
        }

        if (!groupsName.isEmpty()) {
            boolExpression = boolExpression.and(productGroups.groupName.like("%" + groupsName + "%"));
        }

        return boolExpression;
    }
}
