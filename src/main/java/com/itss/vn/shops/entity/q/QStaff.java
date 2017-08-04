package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.Staff;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QStaff is a Querydsl query type for Staff
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStaff extends EntityPathBase<Staff> {

    private static final long serialVersionUID = 393681318L;

    public static final QStaff staff = new QStaff("staff");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    public final StringPath idNo = createString("idNo");

    public final StringPath staffCode = createString("staffCode");

    public final NumberPath<Integer> staffId = createNumber("staffId", Integer.class);

    public final StringPath staffName = createString("staffName");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath tel = createString("tel");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QStaff(String variable) {
        super(Staff.class, forVariable(variable));
    }

    public QStaff(Path<? extends Staff> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStaff(PathMetadata metadata) {
        super(Staff.class, metadata);
    }

}

