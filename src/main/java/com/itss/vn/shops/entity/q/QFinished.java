package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.Finished;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QFinished is a Querydsl query type for Finished
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFinished extends EntityPathBase<Finished> {

    private static final long serialVersionUID = 920562668L;

    public static final QFinished finished = new QFinished("finished");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath finishedCode = createString("finishedCode");

    public final NumberPath<Integer> finishedId = createNumber("finishedId", Integer.class);

    public final StringPath finishedName = createString("finishedName");

    public final NumberPath<Float> price = createNumber("price", Float.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Integer> quantityRes = createNumber("quantityRes", Integer.class);

    public final StringPath staffCodeCreate = createString("staffCodeCreate");

    public final StringPath staffCodeUpdate = createString("staffCodeUpdate");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QFinished(String variable) {
        super(Finished.class, forVariable(variable));
    }

    public QFinished(Path<? extends Finished> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFinished(PathMetadata metadata) {
        super(Finished.class, metadata);
    }

}

