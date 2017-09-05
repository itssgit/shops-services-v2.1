package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.ProductDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface ProductRepositoryCustom {

    ProductDTO add(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    Integer deleteById(Integer id);

    ProductDTO findById(Integer id);

    List<ProductDTO> find();
}
