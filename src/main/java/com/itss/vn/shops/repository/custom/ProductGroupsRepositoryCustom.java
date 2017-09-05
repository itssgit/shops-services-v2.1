package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.ProductGroupsDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface ProductGroupsRepositoryCustom {

    ProductGroupsDTO add(ProductGroupsDTO productGroupsDTO);

    ProductGroupsDTO update(ProductGroupsDTO productGroupsDTO);

    Integer deleteById(Integer id);

    ProductGroupsDTO findById(Integer id);

    List<ProductGroupsDTO> find();
}
