package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.AttributeGroupsDTO;
import com.itss.vn.shops.repository.AttributeGroupsRepository;
import com.itss.vn.shops.service.AttributeGroupsService;
import org.springframework.beans.factory.annotation.Autowired;


public class AttributeGroupsServiceImpl implements AttributeGroupsService {

    @Autowired
    AttributeGroupsRepository attributeGroupsRepository;


    @Override
    public AttributeGroupsDTO addAttributeGroups(AttributeGroupsDTO attributeGroupsDTO) {
        if (attributeGroupsDTO.getAttributeGroupId() == null || attributeGroupsDTO.getAttributeGroupId() == 0) {
            attributeGroupsDTO.setAttributeGroupId(null);
            return attributeGroupsRepository.add(attributeGroupsDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public AttributeGroupsDTO updateAttributeGroups(AttributeGroupsDTO attributeGroupsDTO) {
        if (attributeGroupsDTO.getAttributeGroupId() != null) {
            return attributeGroupsRepository.update(attributeGroupsDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer deleteAttributeGroups(Integer id) {
        if (id != null) {
            return attributeGroupsRepository.deleteById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }


    @Override
    public AttributeGroupsDTO getAttributeGroupsDTOById(Integer id) {
        if (id != null) {
            return attributeGroupsRepository.findById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }
}

