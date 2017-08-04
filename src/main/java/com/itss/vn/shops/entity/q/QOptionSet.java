package com.itss.vn.shops.entity.q;

import com.itss.vn.shops.entity.OptionSet;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QOptionSet is a Querydsl query type for OptionSet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOptionSet extends EntityPathBase<OptionSet> {

    private static final long serialVersionUID = -273256589L;

    public static final QOptionSet optionSet = new QOptionSet("optionSet");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath optionSetCode = createString("optionSetCode");

    public final StringPath optionSetDesc = createString("optionSetDesc");

    public final NumberPath<Integer> optionSetId = createNumber("optionSetId", Integer.class);

    public final StringPath staffCode = createString("staffCode");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QOptionSet(String variable) {
        super(OptionSet.class, forVariable(variable));
    }

    public QOptionSet(Path<? extends OptionSet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionSet(PathMetadata metadata) {
        super(OptionSet.class, metadata);
    }

}

