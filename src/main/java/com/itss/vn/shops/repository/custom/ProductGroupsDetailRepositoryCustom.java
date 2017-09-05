package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.ProductGroupsDetailDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface ProductGroupsDetailRepositoryCustom {

    ProductGroupsDetailDTO add(ProductGroupsDetailDTO productGroupsDetailDTO);

    ProductGroupsDetailDTO update(ProductGroupsDetailDTO productGroupsDetailDTO);

    Integer deleteById(Integer id);

    ProductGroupsDetailDTO findById(Integer id);

    List<ProductGroupsDetailDTO> find();
}
