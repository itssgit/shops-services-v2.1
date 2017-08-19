package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.StockTrans;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QStockTrans is a Querydsl query type for StockTrans
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockTrans extends EntityPathBase<StockTrans> {

    private static final long serialVersionUID = -598737364L;

    public static final QStockTrans stockTrans = new QStockTrans("stockTrans");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath staffCode = createString("staffCode");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> stockTransId = createNumber("stockTransId", Integer.class);

    public final StringPath stockTransNo = createString("stockTransNo");

    public final NumberPath<Float> totalPrice = createNumber("totalPrice", Float.class);

    public final NumberPath<Float> totalPromotion = createNumber("totalPromotion", Float.class);

    public final NumberPath<Float> totalVat = createNumber("totalVat", Float.class);

    public final StringPath typeTrans = createString("typeTrans");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QStockTrans(String variable) {
        super(StockTrans.class, forVariable(variable));
    }

    public QStockTrans(Path<? extends StockTrans> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockTrans(PathMetadata metadata) {
        super(StockTrans.class, metadata);
    }

}

