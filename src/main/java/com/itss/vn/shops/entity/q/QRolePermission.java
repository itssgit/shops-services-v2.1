package com.itss.vn.shops.entity.q;

import com.itss.vn.common.entity.q.QBaseEntity;
import com.itss.vn.shops.entity.RolePermission;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRolePermission is a Querydsl query type for RolePermission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRolePermission extends EntityPathBase<RolePermission> {

    private static final long serialVersionUID = 706309855L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRolePermission rolePermission1 = new QRolePermission("rolePermission1");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdTime = _super.createdTime;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QPermission permission;

    public final QRole rolePermission;

    //inherited
    public final DateTimePath<java.util.Date> updatedTime = _super.updatedTime;

    public QRolePermission(String variable) {
        this(RolePermission.class, forVariable(variable), INITS);
    }

    public QRolePermission(Path<? extends RolePermission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRolePermission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRolePermission(PathMetadata metadata, PathInits inits) {
        this(RolePermission.class, metadata, inits);
    }

    public QRolePermission(Class<? extends RolePermission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.permission = inits.isInitialized("permission") ? new QPermission(forProperty("permission")) : null;
        this.rolePermission = inits.isInitialized("rolePermission") ? new QRole(forProperty("rolePermission")) : null;
    }

}

