package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.AttributeDTO;
import com.itss.vn.shops.entity.Attribute;
import com.itss.vn.shops.repository.AttributeRepository;
import com.itss.vn.shops.repository.custom.AttributeRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttributeRepositoryImpl implements AttributeRepositoryCustom {
    @Autowired
    private AttributeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AttributeDTO add(AttributeDTO attributeDTO) {
        attributeDTO.setCreatedTime(new Date());
        attributeDTO.setUpdatedTime(new Date());
        attributeDTO.setAttributeCode(DataUtils.genCode(Constants.CODE_PREFIX.ATTRIBUTE, repository.getMaxId()));
        Attribute attribute = modelMapper.map(attributeDTO, Attribute.class);
        repository.saveAndFlush(attribute);
        return modelMapper.map(attribute, AttributeDTO.class);
    }

    @Override
    public AttributeDTO update(AttributeDTO attributeDTO) {
        Attribute attribute = modelMapper.map(attributeDTO, Attribute.class);
        Attribute attributeUpdate = repository.findOne(attributeDTO.getAttributeId());
        if (attributeUpdate.getAttributeId() != null) {
            attribute.setCreatedTime(attributeUpdate.getCreatedTime());
            attribute.setUpdatedTime(new Date());
            repository.saveAndFlush(attribute);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(attribute, AttributeDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        Attribute attribute = repository.findOne(id);
        if (attribute.getAttributeId() != null) {
            attribute.setStatus(Constants.STATUS.DELETE);
            attribute.setUpdatedTime(new Date());
            repository.saveAndFlush(attribute);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return attribute.getAttributeId();
    }

    @Override
    public AttributeDTO findById(Integer id) {
        Attribute attribute = repository.findOne(id);
        if (attribute == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(attribute, AttributeDTO.class);
    }

    @Override
    public List<AttributeDTO> find() {
        List<Attribute> attributeList = repository.findAll();
        List<AttributeDTO> result = new ArrayList<>();
        if (attributeList.size() > 0) {
            for (Attribute attribute : attributeList) {
                AttributeDTO attributeDTO = modelMapper.map(attribute, AttributeDTO.class);
                result.add(attributeDTO);
            }
        }
        return result;
    }
}
