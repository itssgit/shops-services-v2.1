package com.itss.vn.shops.entity.q;

import com.itss.vn.common.entity.q.QBaseEntity;
import com.itss.vn.shops.entity.Account;
import com.itss.vn.shops.entity.Role;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 2090875120L;

    public static final QRole role = new QRole("role");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<Account, QAccount> accounts = this.<Account, QAccount>createList("accounts", Account.class, QAccount.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdTime = _super.createdTime;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> updatedTime = _super.updatedTime;

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

