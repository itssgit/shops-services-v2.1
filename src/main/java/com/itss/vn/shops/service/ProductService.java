package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ProductDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Interface quan ly kho
 */
public interface ProductService {

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    Integer deleteProduct(Integer productID);

    List<ProductDTO> getListProduct();

    ProductDTO getProductDTOById(Integer productID);

    List<ProductDTO> getListProductByCondition(String productCode, String productName, Integer productType, Integer productStatus, String sortBy, String sortOrder);

}
