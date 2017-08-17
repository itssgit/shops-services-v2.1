package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.OptionSetValueDTO;
import com.itss.vn.shops.repository.OptionSetValueRepository;
import com.itss.vn.shops.service.OptionSetValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@Service
public class OptionSetValueServiceImpl implements OptionSetValueService {

    @Autowired
    private OptionSetValueRepository repository;

    @Override
    public OptionSetValueDTO add(OptionSetValueDTO optionSetValueDTO) {
        if (optionSetValueDTO.getOptionSetValueId() == null || optionSetValueDTO.getOptionSetValueId() == 0) {
            optionSetValueDTO.setOptionSetValueId(null);
            return repository.add(optionSetValueDTO);
        } else {
            throw new BadRequestException("");
        }
    }


    @Override
    public OptionSetValueDTO update(OptionSetValueDTO optionSetValueDTO) {
        if (optionSetValueDTO.getOptionSetValueId() != null) {
            return repository.update(optionSetValueDTO);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public Integer delete(Integer id) {
        if (id != null) {
            return repository.deleteOptionSetValue(id);
        } else {
            throw new BadRequestException("");
        }

    }


    @Override
    public List<OptionSetValueDTO> find() {
        return repository.find();
    }

    @Override
    public OptionSetValueDTO findById(Integer id) {
        if (id != null) {
            return repository.findById(id);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public List<OptionSetValueDTO> findByOptionSetId(Integer optionSetId) {
        if (optionSetId != null) {
           return repository.findByOptionSetId(optionSetId);
        } else {
            throw new BadRequestException("");
        }
    }
}
