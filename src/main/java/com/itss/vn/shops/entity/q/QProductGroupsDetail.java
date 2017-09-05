package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.ProductGroupsDetail;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProductGroupsDetail is a Querydsl query type for ProductGroupsDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductGroupsDetail extends EntityPathBase<ProductGroupsDetail> {

    private static final long serialVersionUID = 534472218L;

    public static final QProductGroupsDetail productGroupsDetail = new QProductGroupsDetail("productGroupsDetail");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Integer> groupId = createNumber("groupId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath productGroupsDesc = createString("productGroupsDesc");

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    public final StringPath staffCodeCreate = createString("staffCodeCreate");

    public final StringPath staffCodeUpdate = createString("staffCodeUpdate");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QProductGroupsDetail(String variable) {
        super(ProductGroupsDetail.class, forVariable(variable));
    }

    public QProductGroupsDetail(Path<? extends ProductGroupsDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductGroupsDetail(PathMetadata metadata) {
        super(ProductGroupsDetail.class, metadata);
    }

}

