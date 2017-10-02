package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.AttributeDTO;
import com.itss.vn.shops.repository.AttributeRepository;
import com.itss.vn.shops.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;


public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;


    @Override
    public AttributeDTO addAttribute(AttributeDTO attributeDTO) {
        if (attributeDTO.getAttributeId() == null || attributeDTO.getAttributeId() == 0) {
            attributeDTO.setAttributeId(null);
            return attributeRepository.add(attributeDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public AttributeDTO updateAttribute(AttributeDTO attributeDTO) {
        if (attributeDTO.getAttributeId() != null) {
            return attributeRepository.update(attributeDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer deleteAttribute(Integer id) {
        if (id != null) {
            return attributeRepository.deleteById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }


    @Override
    public AttributeDTO getAttributeDTOById(Integer id) {
        if (id != null) {
            return attributeRepository.findById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }
}

