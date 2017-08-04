package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.Image;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = 384237601L;

    public static final QImage image = new QImage("image");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Integer> imageId = createNumber("imageId", Integer.class);

    public final StringPath imageName = createString("imageName");

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath objectId = createString("objectId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath tableId = createString("tableId");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QImage(String variable) {
        super(Image.class, forVariable(variable));
    }

    public QImage(Path<? extends Image> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImage(PathMetadata metadata) {
        super(Image.class, metadata);
    }

}

