package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ProductDetailDTO;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Interface quan ly kho
 */
public interface ProductDetailService {

    ProductDetailDTO addProductDetail(ProductDetailDTO productDetailDTO);

    ProductDetailDTO updateProductDetail(ProductDetailDTO productDetailDTO);

    Integer deleteProductDetail(Integer productID);

    ProductDetailDTO getProductDetailDTOById(Integer productID);
}
