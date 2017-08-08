package com.itss.vn.shops.repository;

import com.itss.vn.shops.entity.Image;
import com.itss.vn.shops.repository.custom.ImageRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ImageRepository extends JpaRepository<Image, Integer>, QueryDslPredicateExecutor<Image>, ImageRepositoryCustom {

}
