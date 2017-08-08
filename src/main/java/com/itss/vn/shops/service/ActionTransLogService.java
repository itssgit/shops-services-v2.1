package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ActionTransLogDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Hungdd
 * Service Interface quan ly kho
 */
public interface ActionTransLogService {

    ActionTransLogDTO addActionTransLog(ActionTransLogDTO actionTransLogDTO);

    ActionTransLogDTO updateActionTransLog(ActionTransLogDTO actionTransLogDTO);

    Integer deleteActionTransLog(Integer actionTransLogID);

    List<ActionTransLogDTO> getListActionTransLog();

    ActionTransLogDTO getActionTransLogDTOById(Integer actionTransLogID);
}
