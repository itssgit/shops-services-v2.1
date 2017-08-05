package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.Inventory;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QInventory is a Querydsl query type for Inventory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInventory extends EntityPathBase<Inventory> {

    private static final long serialVersionUID = 155688226L;

    public static final QInventory inventory = new QInventory("inventory");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath inventoryCode = createString("inventoryCode");

    public final StringPath inventoryDesc = createString("inventoryDesc");

    public final NumberPath<Integer> inventoryId = createNumber("inventoryId", Integer.class);

    public final StringPath inventoryName = createString("inventoryName");

    public final NumberPath<Integer> inventoryType = createNumber("inventoryType", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Integer> quotaNo = createNumber("quotaNo", Integer.class);

    public final NumberPath<Float> unitPrice = createNumber("unitPrice", Float.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath unit = createString("unit");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QInventory(String variable) {
        super(Inventory.class, forVariable(variable));
    }

    public QInventory(Path<? extends Inventory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInventory(PathMetadata metadata) {
        super(Inventory.class, metadata);
    }

}

