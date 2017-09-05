package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.ProductGroups;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProductGroups is a Querydsl query type for ProductGroups
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductGroups extends EntityPathBase<ProductGroups> {

    private static final long serialVersionUID = 951915625L;

    public static final QProductGroups productGroups = new QProductGroups("productGroups");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath groupCode = createString("groupCode");

    public final StringPath groupDesc = createString("groupDesc");

    public final NumberPath<Integer> groupId = createNumber("groupId", Integer.class);

    public final StringPath groupName = createString("groupName");

    public final NumberPath<Integer> groupParentId = createNumber("groupParentId", Integer.class);

    public final StringPath staffCodeCreate = createString("staffCodeCreate");

    public final StringPath staffCodeUpdate = createString("staffCodeUpdate");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QProductGroups(String variable) {
        super(ProductGroups.class, forVariable(variable));
    }

    public QProductGroups(Path<? extends ProductGroups> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductGroups(PathMetadata metadata) {
        super(ProductGroups.class, metadata);
    }

}

