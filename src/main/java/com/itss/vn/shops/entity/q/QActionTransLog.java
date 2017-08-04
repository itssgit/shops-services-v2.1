package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.ActionTransLog;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QActionTransLog is a Querydsl query type for ActionTransLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QActionTransLog extends EntityPathBase<ActionTransLog> {

    private static final long serialVersionUID = 651529164L;

    public static final QActionTransLog actionTransLog = new QActionTransLog("actionTransLog");

    public final StringPath actionCode = createString("actionCode");

    public final StringPath actionName = createString("actionName");

    public final NumberPath<Integer> actionTransLogId = createNumber("actionTransLogId", Integer.class);

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath staffCode = createString("staffCode");

    public QActionTransLog(String variable) {
        super(ActionTransLog.class, forVariable(variable));
    }

    public QActionTransLog(Path<? extends ActionTransLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QActionTransLog(PathMetadata metadata) {
        super(ActionTransLog.class, metadata);
    }

}

