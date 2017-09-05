package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.FinishedDTO;
import com.itss.vn.shops.entity.Finished;
import com.itss.vn.shops.repository.FinishedRepository;
import com.itss.vn.shops.repository.custom.FinishedRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinishedRepositoryImpl implements FinishedRepositoryCustom {
    @Autowired
    private FinishedRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FinishedDTO add(FinishedDTO finishedDTO) {
        finishedDTO.setCreatedTime(new Date());
        finishedDTO.setUpdatedTime(new Date());
        finishedDTO.setFinishedCode(DataUtils.genCode(Constants.CODE_PREFIX.FINISHED, repository.getMaxId()));
        Finished finished = modelMapper.map(finishedDTO, Finished.class);
        repository.saveAndFlush(finished);
        return modelMapper.map(finished, FinishedDTO.class);
    }

    @Override
    public FinishedDTO update(FinishedDTO finishedDTO) {
        Finished finished = modelMapper.map(finishedDTO, Finished.class);
        Finished finishedUpdate = repository.findOne(finishedDTO.getFinishedId());
        if (finishedUpdate.getFinishedId() != null) {
            finished.setCreatedTime(finishedUpdate.getCreatedTime());
            finished.setUpdatedTime(new Date());
            repository.saveAndFlush(finished);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(finished, FinishedDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        Finished finished = repository.findOne(id);
        if (finished.getFinishedId() != null) {
            finished.setStatus(Constants.STATUS.DELETE);
            finished.setUpdatedTime(new Date());
            repository.saveAndFlush(finished);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return finished.getFinishedId();
    }

    @Override
    public FinishedDTO findById(Integer id) {
        Finished finished = repository.findOne(id);
        if (finished == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(finished, FinishedDTO.class);
    }

    @Override
    public List<FinishedDTO> find() {
        List<Finished> finishedList = repository.findAll();
        List<FinishedDTO> result = new ArrayList<>();
        if (finishedList.size() > 0) {
            for (Finished finished : finishedList) {
                FinishedDTO finishedDTO = modelMapper.map(finished, FinishedDTO.class);
                result.add(finishedDTO);
            }
        }
        return result;
    }
}
