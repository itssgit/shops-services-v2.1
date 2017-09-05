package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.FinishedDetailDTO;
import com.itss.vn.shops.entity.FinishedDetail;
import com.itss.vn.shops.repository.FinishedDetailRepository;
import com.itss.vn.shops.repository.custom.FinishedDetailRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinishedDetailRepositoryImpl implements FinishedDetailRepositoryCustom {
    @Autowired
    private FinishedDetailRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FinishedDetailDTO add(FinishedDetailDTO finishedDetailDTO) {
        finishedDetailDTO.setCreatedTime(new Date());
        finishedDetailDTO.setUpdatedTime(new Date());
        FinishedDetail finishedDetail = modelMapper.map(finishedDetailDTO, FinishedDetail.class);
        repository.saveAndFlush(finishedDetail);
        return modelMapper.map(finishedDetail, FinishedDetailDTO.class);
    }

    @Override
    public FinishedDetailDTO update(FinishedDetailDTO finishedDetailDTO) {
        FinishedDetail finishedDetail = modelMapper.map(finishedDetailDTO, FinishedDetail.class);
        FinishedDetail finishedDetailUpdate = repository.findOne(finishedDetailDTO.getId());
        if (finishedDetailUpdate.getId() != null) {
            finishedDetail.setCreatedTime(finishedDetailUpdate.getCreatedTime());
            finishedDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(finishedDetail);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(finishedDetail, FinishedDetailDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        FinishedDetail finishedDetail = repository.findOne(id);
        if (finishedDetail.getId() != null) {
            finishedDetail.setStatus(Constants.STATUS.DELETE);
            finishedDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(finishedDetail);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return finishedDetail.getId();
    }

    @Override
    public FinishedDetailDTO findById(Integer id) {
        FinishedDetail finishedDetail = repository.findOne(id);
        if (finishedDetail == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(finishedDetail, FinishedDetailDTO.class);
    }

    @Override
    public List<FinishedDetailDTO> find() {
        List<FinishedDetail> finishedDetailList = repository.findAll();
        List<FinishedDetailDTO> result = new ArrayList<>();
        if (finishedDetailList.size() > 0) {
            for (FinishedDetail finishedDetail : finishedDetailList) {
                FinishedDetailDTO finishedDetailDTO = modelMapper.map(finishedDetail, FinishedDetailDTO.class);
                result.add(finishedDetailDTO);
            }
        }
        return result;
    }
}
