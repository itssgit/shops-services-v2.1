package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.OptionSetValue;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QOptionSetValue is a Querydsl query type for OptionSetValue
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOptionSetValue extends EntityPathBase<OptionSetValue> {

    private static final long serialVersionUID = -1524768322L;

    public static final QOptionSetValue optionSetValue1 = new QOptionSetValue("optionSetValue1");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Integer> optionSetId = createNumber("optionSetId", Integer.class);

    public final StringPath optionSetName = createString("optionSetName");

    public final StringPath optionSetValue = createString("optionSetValue");

    public final NumberPath<Integer> optionSetValueId = createNumber("optionSetValueId", Integer.class);

    public final StringPath staffCode = createString("staffCode");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QOptionSetValue(String variable) {
        super(OptionSetValue.class, forVariable(variable));
    }

    public QOptionSetValue(Path<? extends OptionSetValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionSetValue(PathMetadata metadata) {
        super(OptionSetValue.class, metadata);
    }

}

