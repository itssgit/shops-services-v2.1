package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.AttributeGroupsDTO;
import com.itss.vn.shops.entity.AttributeGroups;
import com.itss.vn.shops.repository.AttributeGroupsRepository;
import com.itss.vn.shops.repository.custom.AttributeGroupsRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttributeGroupsRepositoryImpl implements AttributeGroupsRepositoryCustom {

    @Autowired
    private AttributeGroupsRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AttributeGroupsDTO add(AttributeGroupsDTO attributeGroupsDTO) {
        attributeGroupsDTO.setCreatedTime(new Date());
        attributeGroupsDTO.setUpdatedTime(new Date());
        attributeGroupsDTO.setAttributeGroupCode(DataUtils.genCode(Constants.CODE_PREFIX.ATTRIBUTE_GROUPS, repository.getMaxId()));
        AttributeGroups attributeGroups = modelMapper.map(attributeGroupsDTO, AttributeGroups.class);
        repository.saveAndFlush(attributeGroups);
        return modelMapper.map(attributeGroups, AttributeGroupsDTO.class);
    }

    @Override
    public AttributeGroupsDTO update(AttributeGroupsDTO attributeGroupsDTO) {
        AttributeGroups attributeGroups = modelMapper.map(attributeGroupsDTO, AttributeGroups.class);
        AttributeGroups attributeGroupsUpdate = repository.findOne(attributeGroupsDTO.getAttributeGroupId());
        if (attributeGroupsUpdate.getAttributeGroupId() != null) {
            attributeGroups.setCreatedTime(attributeGroupsUpdate.getCreatedTime());
            attributeGroups.setUpdatedTime(new Date());
            repository.saveAndFlush(attributeGroups);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(attributeGroups, AttributeGroupsDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        AttributeGroups attributeGroups = repository.findOne(id);
        if (attributeGroups.getAttributeGroupId() != null) {
            attributeGroups.setStatus(Constants.STATUS.DELETE);
            attributeGroups.setUpdatedTime(new Date());
            repository.saveAndFlush(attributeGroups);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return attributeGroups.getAttributeGroupId();
    }

    @Override
    public AttributeGroupsDTO findById(Integer id) {
        AttributeGroups attributeGroups = repository.findOne(id);
        if (attributeGroups == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(attributeGroups, AttributeGroupsDTO.class);
    }

    @Override
    public List<AttributeGroupsDTO> find() {
        List<AttributeGroups> attributeGroupsList = repository.findAll();
        List<AttributeGroupsDTO> result = new ArrayList<>();
        if (attributeGroupsList.size() > 0) {
            for (AttributeGroups attributeGroups : attributeGroupsList) {
                AttributeGroupsDTO attributeGroupsDTO = modelMapper.map(attributeGroups, AttributeGroupsDTO.class);
                result.add(attributeGroupsDTO);
            }
        }
        return result;
    }
}
