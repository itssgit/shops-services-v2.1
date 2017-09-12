package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ProductGroupsDTO;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Interface quan ly kho
 */
public interface ProductGroupsService {

    ProductGroupsDTO addProductGroups(ProductGroupsDTO productGroupsDTO);

    ProductGroupsDTO updateProductGroups(ProductGroupsDTO productGroupsDTO);

    Integer deleteProductGroups(Integer productID);

    ProductGroupsDTO getProductGroupsDTOById(Integer productID);
}
