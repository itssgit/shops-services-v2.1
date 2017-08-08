package com.itss.vn.shops.repository.impl;


import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.ActionTransLogDTO;
import com.itss.vn.shops.entity.ActionTransLog;
import com.itss.vn.shops.repository.ActionTransLogRepository;
import com.itss.vn.shops.repository.custom.ActionTransLogRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public class ActionTransLogRepositoryImpl implements ActionTransLogRepositoryCustom {

    @Autowired
    private ActionTransLogRepository actionTransLogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ActionTransLogDTO addActionTransLog(ActionTransLogDTO actionTransLogDTO) {
        ActionTransLog actionTransLog = modelMapper.map(actionTransLogDTO, ActionTransLog.class);
        actionTransLogRepository.saveAndFlush(actionTransLog);

        return modelMapper.map(actionTransLog, ActionTransLogDTO.class);
    }

    @Override
    public ActionTransLogDTO updateActionTransLog(ActionTransLogDTO actionTransLogDTO) {
        ActionTransLog actionTransLog = modelMapper.map(actionTransLogDTO, ActionTransLog.class);

        ActionTransLog actionTransLogUpdate = actionTransLogRepository.findOne(actionTransLogDTO.getActionTransLogId());
        if (actionTransLogUpdate.getActionTransLogId() != null) {
            actionTransLogUpdate = actionTransLog;
            actionTransLogRepository.saveAndFlush(actionTransLog);
        } else throw new RestException("Record doesn't exist");

        return modelMapper.map(actionTransLogUpdate, ActionTransLogDTO.class);
    }

    @Override
    public Integer deleteActionTransLog(Integer actionTransLogID) {
        ActionTransLog actionTransLog = actionTransLogRepository.findOne(actionTransLogID);
        if (actionTransLog.getActionTransLogId() != null) {
            actionTransLogRepository.deleteActionTransLog(actionTransLogID);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return actionTransLogID;
    }

    @Override
    public ActionTransLogDTO getActionTransLogDTOById(Integer actionTransLogID) {
        ActionTransLog actionTransLog = actionTransLogRepository.findOne(actionTransLogID);

        if (actionTransLog == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(actionTransLog, ActionTransLogDTO.class);
    }

    @Override
    public List<ActionTransLogDTO> getActionTransLog() {
        List<ActionTransLog> actionTransLogList = actionTransLogRepository.findAll();

        List<ActionTransLogDTO> result = new ArrayList<>();
        if (actionTransLogList.size() > 0) {
            for (ActionTransLog actionTransLog : actionTransLogList) {
                ActionTransLogDTO actionTransLogDTO = modelMapper.map(actionTransLog, ActionTransLogDTO.class);
                result.add(actionTransLogDTO);
            }
        }
        return result;
    }
}
