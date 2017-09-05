package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.FinishedDetail;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QFinishedDetail is a Querydsl query type for FinishedDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFinishedDetail extends EntityPathBase<FinishedDetail> {

    private static final long serialVersionUID = 536874845L;

    public static final QFinishedDetail finishedDetail = new QFinishedDetail("finishedDetail");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Integer> finishedId = createNumber("finishedId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> inventoryId = createNumber("inventoryId", Integer.class);

    public final NumberPath<Integer> quota = createNumber("quota", Integer.class);

    public final StringPath staffCodeCreate = createString("staffCodeCreate");

    public final StringPath staffCodeUpdate = createString("staffCodeUpdate");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QFinishedDetail(String variable) {
        super(FinishedDetail.class, forVariable(variable));
    }

    public QFinishedDetail(Path<? extends FinishedDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFinishedDetail(PathMetadata metadata) {
        super(FinishedDetail.class, metadata);
    }

}

