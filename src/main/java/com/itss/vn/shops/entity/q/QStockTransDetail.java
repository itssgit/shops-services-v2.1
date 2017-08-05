package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.StockTransDetail;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QStockTransDetail is a Querydsl query type for StockTransDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockTransDetail extends EntityPathBase<StockTransDetail> {

    private static final long serialVersionUID = 624603549L;

    public static final QStockTransDetail stockTransDetail = new QStockTransDetail("stockTransDetail");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Integer> inventoryId = createNumber("inventoryId", Integer.class);

    public final NumberPath<Float> promotion = createNumber("promotion", Float.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> stockTransDetailId = createNumber("stockTransDetailId", Integer.class);

    public final NumberPath<Integer> stockTransId = createNumber("stockTransId", Integer.class);

    public final NumberPath<Float> unitPrice = createNumber("unitPrice", Float.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final NumberPath<Float> vat = createNumber("vat", Float.class);

    public QStockTransDetail(String variable) {
        super(StockTransDetail.class, forVariable(variable));
    }

    public QStockTransDetail(Path<? extends StockTransDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockTransDetail(PathMetadata metadata) {
        super(StockTransDetail.class, metadata);
    }

}

