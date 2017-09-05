package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.ProductDetailDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface ProductDetailRepositoryCustom {

    ProductDetailDTO add(ProductDetailDTO productDetailDTO);

    ProductDetailDTO update(ProductDetailDTO productDetailDTO);

    Integer deleteById(Integer id);

    ProductDetailDTO findById(Integer id);

    List<ProductDetailDTO> find();
}
