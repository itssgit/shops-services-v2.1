package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.OptionSetDTO;
import com.itss.vn.shops.entity.Image;
import com.itss.vn.shops.entity.OptionSet;
import com.itss.vn.shops.repository.OptionSetRepository;
import com.itss.vn.shops.repository.custom.OptionSetRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class OptionSetRepositoryImpl implements OptionSetRepositoryCustom {
    
    @Autowired
    private OptionSetRepository optionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OptionSetDTO add(OptionSetDTO optionSetDTO) {
        OptionSet optionSet = modelMapper.map(optionSetDTO, OptionSet.class);
        optionRepository.saveAndFlush(optionSet);
        return modelMapper.map(optionSet, OptionSetDTO.class);
    }

    @Override
    public OptionSetDTO update(OptionSetDTO optionSetDTO) {
        OptionSet optionSet = modelMapper.map(optionSetDTO, OptionSet.class);
        OptionSet optionSetUpdate = optionRepository.findOne(optionSetDTO.getOptionSetId());
        if (optionSetUpdate.getOptionSetId() != null) {
            optionRepository.saveAndFlush(optionSet);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return modelMapper.map(optionSet, OptionSetDTO.class);
    }

    @Override
    public Integer deleteOptionSet(Integer id) {
        OptionSet optionSet = optionRepository.findOne(id);
        if (optionSet.getOptionSetId() != null) {
            optionSet.setStatus(Constants.STATUS.DELETE);
            optionSet.setUpdatedTime(new Date());
            optionRepository.saveAndFlush(optionSet);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return optionSet.getOptionSetId();
    }

    @Override
    public OptionSetDTO findById(Integer id) {
        OptionSet optionSet = optionRepository.findOne(id);

        if (optionSet == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(optionSet, OptionSetDTO.class);
    }

    @Override
    public List<OptionSetDTO> find() {
        List<OptionSet> optionSetList = optionRepository.findAll();
        List<OptionSetDTO> result = new ArrayList<>();
        if (optionSetList.size() > 0) {
            for (OptionSet optionSet : optionSetList) {
                OptionSetDTO OptionSetDTO = modelMapper.map(optionSet, OptionSetDTO.class);
                result.add(OptionSetDTO);
            }
        }
        return result;
    }
}
