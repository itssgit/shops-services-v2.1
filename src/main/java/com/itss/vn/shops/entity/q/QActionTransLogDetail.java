package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.ActionTransLogDetail;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QActionTransLogDetail is a Querydsl query type for ActionTransLogDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QActionTransLogDetail extends EntityPathBase<ActionTransLogDetail> {

    private static final long serialVersionUID = -1769502915L;

    public static final QActionTransLogDetail actionTransLogDetail = new QActionTransLogDetail("actionTransLogDetail");

    public final StringPath actionDetailDesc = createString("actionDetailDesc");

    public final NumberPath<Integer> actionTransLogDetailId = createNumber("actionTransLogDetailId", Integer.class);

    public final NumberPath<Integer> actionTransLogId = createNumber("actionTransLogId", Integer.class);

    public final NumberPath<Integer> columnId = createNumber("columnId", Integer.class);

    public final StringPath columnName = createString("columnName");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath newValue = createString("newValue");

    public final StringPath oldValue = createString("oldValue");

    public final StringPath staffCode = createString("staffCode");

    public final StringPath tableName = createString("tableName");

    public QActionTransLogDetail(String variable) {
        super(ActionTransLogDetail.class, forVariable(variable));
    }

    public QActionTransLogDetail(Path<? extends ActionTransLogDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QActionTransLogDetail(PathMetadata metadata) {
        super(ActionTransLogDetail.class, metadata);
    }

}

