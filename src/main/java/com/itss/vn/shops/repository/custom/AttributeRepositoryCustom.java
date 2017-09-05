package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.AttributeDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface AttributeRepositoryCustom {

    AttributeDTO add(AttributeDTO attributeDTO);

    AttributeDTO update(AttributeDTO attributeDTO);

    Integer deleteById(Integer id);

    AttributeDTO findById(Integer id);

    List<AttributeDTO> find();
}
