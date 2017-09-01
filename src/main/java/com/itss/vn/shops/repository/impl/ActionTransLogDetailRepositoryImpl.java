package com.itss.vn.shops.repository.impl;


import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.ActionTransLogDetailDTO;
import com.itss.vn.shops.entity.ActionTransLogDetail;
import com.itss.vn.shops.repository.ActionTransLogDetailRepository;
import com.itss.vn.shops.repository.custom.ActionTransLogDetailRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public class ActionTransLogDetailRepositoryImpl implements ActionTransLogDetailRepositoryCustom {

    @Autowired
    private ActionTransLogDetailRepository actionTransLogDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ActionTransLogDetailDTO addActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDetailDTO) {
        ActionTransLogDetail actionTransLogDetail = modelMapper.map(actionTransLogDetailDTO, ActionTransLogDetail.class);
        actionTransLogDetail.setCreatedTime(new Date());
        actionTransLogDetailRepository.saveAndFlush(actionTransLogDetail);

        return modelMapper.map(actionTransLogDetail, ActionTransLogDetailDTO.class);
    }

    @Override
    public ActionTransLogDetailDTO updateActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDetailDTO) {
        ActionTransLogDetail actionTransLogDetail = modelMapper.map(actionTransLogDetailDTO, ActionTransLogDetail.class);

        ActionTransLogDetail actionTransLogDetailUpdate = actionTransLogDetailRepository.findOne(actionTransLogDetailDTO.getActionTransLogDetailId());
        if (actionTransLogDetailUpdate.getActionTransLogDetailId() != null) {
            actionTransLogDetail.setCreatedTime(actionTransLogDetailUpdate.getCreatedTime());
            actionTransLogDetailRepository.saveAndFlush(actionTransLogDetail);
        } else throw new RestException("Record doesn't exist");

        return modelMapper.map(actionTransLogDetail, ActionTransLogDetailDTO.class);
    }

    @Override
    public Integer deleteActionTransLogDetail(Integer actionTransLogDetailID) {
        ActionTransLogDetail actionTransLogDetail = actionTransLogDetailRepository.findOne(actionTransLogDetailID);
        if (actionTransLogDetail.getActionTransLogDetailId() != null) {
            actionTransLogDetailRepository.delete(actionTransLogDetailID);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return actionTransLogDetailID;
    }

    @Override
    public ActionTransLogDetailDTO getActionTransLogDetailDTOById(Integer actionTransLogDetailID) {
        ActionTransLogDetail actionTransLogDetail = actionTransLogDetailRepository.findOne(actionTransLogDetailID);

        if (actionTransLogDetail == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(actionTransLogDetail, ActionTransLogDetailDTO.class);
    }

    @Override
    public List<ActionTransLogDetailDTO> getActionTransLogDetail() {
        List<ActionTransLogDetail> actionTransLogDetailList = actionTransLogDetailRepository.findAll();

        List<ActionTransLogDetailDTO> result = new ArrayList<>();
        if (actionTransLogDetailList.size() > 0) {
            for (ActionTransLogDetail actionTransLogDetail : actionTransLogDetailList) {
                ActionTransLogDetailDTO actionTransLogDetailDTO = modelMapper.map(actionTransLogDetail, ActionTransLogDetailDTO.class);
                result.add(actionTransLogDetailDTO);
            }
        }
        return result;
    }
}
