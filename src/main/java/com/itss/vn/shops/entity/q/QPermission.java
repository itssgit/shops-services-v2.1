package com.itss.vn.shops.entity.q;

import com.itss.vn.common.entity.q.QBaseEntity;
import com.itss.vn.shops.entity.Permission;
import com.itss.vn.shops.entity.RolePermission;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QPermission is a Querydsl query type for Permission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPermission extends EntityPathBase<Permission> {

    private static final long serialVersionUID = -1772176695L;

    public static final QPermission permission = new QPermission("permission");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdTime = _super.createdTime;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final ListPath<RolePermission, QRolePermission> rolePermissions = this.<RolePermission, QRolePermission>createList("rolePermissions", RolePermission.class, QRolePermission.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedTime = _super.updatedTime;

    public QPermission(String variable) {
        super(Permission.class, forVariable(variable));
    }

    public QPermission(Path<? extends Permission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermission(PathMetadata metadata) {
        super(Permission.class, metadata);
    }

}

