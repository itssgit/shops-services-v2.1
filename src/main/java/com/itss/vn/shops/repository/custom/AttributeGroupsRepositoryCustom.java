package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.AttributeGroupsDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface AttributeGroupsRepositoryCustom {

    AttributeGroupsDTO add(AttributeGroupsDTO attributeGroupsDTO);

    AttributeGroupsDTO update(AttributeGroupsDTO attributeGroupsDTO);

    Integer deleteById(Integer id);

    AttributeGroupsDTO findById(Integer id);

    List<AttributeGroupsDTO> find();
}
