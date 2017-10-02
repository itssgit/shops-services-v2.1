package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.AttributeGroupsDTO;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Interface quan ly kho
 */
public interface AttributeGroupsService {

    AttributeGroupsDTO addAttributeGroups(AttributeGroupsDTO attributeGroupsDTO);

    AttributeGroupsDTO updateAttributeGroups(AttributeGroupsDTO attributeGroupsDTO);

    Integer deleteAttributeGroups(Integer attributeID);

    AttributeGroupsDTO getAttributeGroupsDTOById(Integer attributeID);

}
