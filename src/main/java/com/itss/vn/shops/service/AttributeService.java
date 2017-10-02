package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.AttributeDTO;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Interface quan ly kho
 */
public interface AttributeService {

    AttributeDTO addAttribute(AttributeDTO attributeDTO);

    AttributeDTO updateAttribute(AttributeDTO attributeDTO);

    Integer deleteAttribute(Integer attributeID);

    AttributeDTO getAttributeDTOById(Integer attributeID);

}
