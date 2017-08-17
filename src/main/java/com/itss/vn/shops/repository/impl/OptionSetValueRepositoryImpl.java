package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.OptionSetDTO;
import com.itss.vn.shops.dto.OptionSetValueDTO;
import com.itss.vn.shops.entity.OptionSetValue;
import com.itss.vn.shops.repository.OptionSetValueRepository;
import com.itss.vn.shops.repository.custom.OptionSetValueRepositoryCustom;
import com.itss.vn.shops.repository.predicate.OptionSetValuePredicate;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class OptionSetValueRepositoryImpl implements OptionSetValueRepositoryCustom {

    @Autowired
    private OptionSetValueRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OptionSetValueDTO add(OptionSetValueDTO optionSetValueDTO) {
        OptionSetValue optionSetValue = modelMapper.map(optionSetValueDTO, OptionSetValue.class);
        repository.saveAndFlush(optionSetValue);
        return modelMapper.map(optionSetValue, OptionSetValueDTO.class);
    }

    @Override
    public OptionSetValueDTO update(OptionSetValueDTO optionSetValueDTO) {
        OptionSetValue optionSetValue = modelMapper.map(optionSetValueDTO, OptionSetValue.class);
        OptionSetValue optionSetValueUpdate = repository.findOne(optionSetValueDTO.getOptionSetValueId());
        if (optionSetValueUpdate.getOptionSetValueId() != null) {
            repository.saveAndFlush(optionSetValue);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return modelMapper.map(optionSetValue, OptionSetValueDTO.class);
    }

    @Override
    public Integer deleteOptionSetValue (Integer id) {
        OptionSetValue optionSetValue = repository.findOne(id);
        if (optionSetValue.getOptionSetValueId() != null) {
            optionSetValue.setStatus(Constants.STATUS.DELETE);
            optionSetValue.setUpdatedTime(new Date());
            repository.saveAndFlush(optionSetValue);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return optionSetValue.getOptionSetValueId();
    }

    @Override
    public OptionSetValueDTO findById(Integer id) {
        OptionSetValue optionSetValue = repository.findOne(id);

        if (optionSetValue == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(optionSetValue, OptionSetValueDTO.class);
    }

    @Override
    public List<OptionSetValueDTO> find() {
        List<OptionSetValue> optionSetValueList = repository.findAll();
        List<OptionSetValueDTO> result = new ArrayList<>();
        if (optionSetValueList.size() > 0) {
            for (OptionSetValue optionSetValue : optionSetValueList) {
                OptionSetValueDTO optionSetValueDTO = modelMapper.map(optionSetValue, OptionSetValueDTO.class);
                result.add(optionSetValueDTO);
            }
        }
        return result;
    }

    @Override
    public List<OptionSetValueDTO> findByOptionSetId(Integer optionSetId) {
        List<OptionSetValueDTO> result = new ArrayList<>();
        Predicate where = OptionSetValuePredicate.findByOptionSetId(optionSetId);
        Iterator<OptionSetValue> optionSetValueList = repository.findAll(where).iterator();
        while (optionSetValueList.hasNext()){
            OptionSetValueDTO optionSetValueDTO = modelMapper.map(optionSetValueList.next(), OptionSetValueDTO.class);
            result.add(optionSetValueDTO);
        }
        return result;
    }
}
