package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.AttributeGroups;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QAttributeGroups is a Querydsl query type for AttributeGroups
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAttributeGroups extends EntityPathBase<AttributeGroups> {

    private static final long serialVersionUID = -2052447530L;

    public static final QAttributeGroups attributeGroups = new QAttributeGroups("attributeGroups");

    public final StringPath attributeGroupCode = createString("attributeGroupCode");

    public final StringPath attributeGroupDesc = createString("attributeGroupDesc");

    public final NumberPath<Integer> attributeGroupId = createNumber("attributeGroupId", Integer.class);

    public final StringPath attributeGroupName = createString("attributeGroupName");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath staffCodeCreate = createString("staffCodeCreate");

    public final StringPath staffCodeUpdate = createString("staffCodeUpdate");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QAttributeGroups(String variable) {
        super(AttributeGroups.class, forVariable(variable));
    }

    public QAttributeGroups(Path<? extends AttributeGroups> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttributeGroups(PathMetadata metadata) {
        super(AttributeGroups.class, metadata);
    }

}

