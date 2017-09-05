package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.Attribute;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QAttribute is a Querydsl query type for Attribute
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAttribute extends EntityPathBase<Attribute> {

    private static final long serialVersionUID = -2105594270L;

    public static final QAttribute attribute = new QAttribute("attribute");

    public final StringPath attributeCode = createString("attributeCode");

    public final StringPath attributeDesc = createString("attributeDesc");

    public final NumberPath<Integer> attributeGroupId = createNumber("attributeGroupId", Integer.class);

    public final NumberPath<Integer> attributeId = createNumber("attributeId", Integer.class);

    public final StringPath attributeName = createString("attributeName");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath staffCodeCreate = createString("staffCodeCreate");

    public final StringPath staffCodeUpdate = createString("staffCodeUpdate");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QAttribute(String variable) {
        super(Attribute.class, forVariable(variable));
    }

    public QAttribute(Path<? extends Attribute> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttribute(PathMetadata metadata) {
        super(Attribute.class, metadata);
    }

}

