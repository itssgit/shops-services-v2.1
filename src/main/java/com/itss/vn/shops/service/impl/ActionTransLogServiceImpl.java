package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.ActionTransLogDTO;
import com.itss.vn.shops.repository.ActionTransLogRepository;
import com.itss.vn.shops.service.ActionTransLogDetailService;
import com.itss.vn.shops.service.ActionTransLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Impl quan ly kho
 */

@Service
public class ActionTransLogServiceImpl implements ActionTransLogService {

    @Autowired
    private ActionTransLogRepository actionTransLogRepository;

    @Autowired
    private ActionTransLogDetailService actionTransLogDetailService;

    @Override
    public ActionTransLogDTO addActionTransLog(ActionTransLogDTO actionTransLogDTO) {
        ActionTransLogDTO resultDTO = new ActionTransLogDTO();
        if (actionTransLogDTO.getActionTransLogId() == null || actionTransLogDTO.getActionTransLogId() == 0) {
            actionTransLogDTO.setActionTransLogId(null);
            resultDTO = actionTransLogRepository.addActionTransLog(actionTransLogDTO);
            resultDTO.setActionTransLogDetailDTOList(actionTransLogDetailService.addListActionTransLogDetailDTO(actionTransLogDTO.getActionTransLogDetailDTOList(), resultDTO.getActionTransLogId()));

        } else {
            throw new BadRequestException();
        }

        return resultDTO;
    }

    @Override
    public ActionTransLogDTO updateActionTransLog(ActionTransLogDTO actionTransLogDTO) {
        if (actionTransLogDTO.getActionTransLogId() != null) {
            return actionTransLogRepository.updateActionTransLog(actionTransLogDTO);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public Integer deleteActionTransLog(Integer actionTransLogID) {
        return actionTransLogRepository.deleteActionTransLog(actionTransLogID);
    }

    @Override
    public List<ActionTransLogDTO> getListActionTransLog() {
        return actionTransLogRepository.getActionTransLog();
    }

    @Override
    public ActionTransLogDTO getActionTransLogDTOById(Integer actionTransLogID) {
        return actionTransLogRepository.getActionTransLogDTOById(actionTransLogID);
    }
}
