package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ProductGroupsDTO;

import java.util.List;

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

    List<ProductGroupsDTO> getListProductGroupsDTOByCondition(String groupsCode, Integer status, String groupsName, String parentCode);

    String getParrentCodeByParentId(Integer parentGroupId);
}
