package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.ActionTransLogDetailDTO;
import com.itss.vn.shops.repository.ActionTransLogDetailRepository;
import com.itss.vn.shops.service.ActionTransLogDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Hungdd
 * Service Impl quan ly kho
 */

@Service
public class ActionTransLogDetailServiceImpl implements ActionTransLogDetailService {

    @Autowired
    private ActionTransLogDetailRepository actionTransLogDetailRepository;

    @Override
    public ActionTransLogDetailDTO addActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDetailDTO) {
        if (actionTransLogDetailDTO.getActionTransLogDetailId() == null || actionTransLogDetailDTO.getActionTransLogDetailId() == 0) {
            actionTransLogDetailDTO.setActionTransLogDetailId(null);
            return actionTransLogDetailRepository.addActionTransLogDetail(actionTransLogDetailDTO);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public ActionTransLogDetailDTO updateActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDetailDTO) {
        if (actionTransLogDetailDTO.getActionTransLogDetailId() != null) {
            return actionTransLogDetailRepository.updateActionTransLogDetail(actionTransLogDetailDTO);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public Integer deleteActionTransLogDetail(Integer actionTransLogDetailID) {
        return actionTransLogDetailRepository.deleteActionTransLogDetail(actionTransLogDetailID);
    }

    @Override
    public List<ActionTransLogDetailDTO> getListActionTransLogDetail() {
        return actionTransLogDetailRepository.getActionTransLogDetail();
    }

    @Override
    public ActionTransLogDetailDTO getActionTransLogDetailDTOById(Integer actionTransLogDetailID) {
        return actionTransLogDetailRepository.getActionTransLogDetailDTOById(actionTransLogDetailID);
    }

    @Override
    public List<ActionTransLogDetailDTO> addListActionTransLogDetailDTO(List<ActionTransLogDetailDTO> actionTransLogDetailDTOList, Integer ActionTransLogId) {
        List<ActionTransLogDetailDTO> resultList = new ArrayList<>();
        for(ActionTransLogDetailDTO actionTransLogDetailDTO : actionTransLogDetailDTOList){
            try{
                actionTransLogDetailDTO.setActionTransLogId(ActionTransLogId);
                resultList.add(this.addActionTransLogDetail(actionTransLogDetailDTO));
            } catch (Exception ex) {

            }
        };
        return resultList;
    }
}
