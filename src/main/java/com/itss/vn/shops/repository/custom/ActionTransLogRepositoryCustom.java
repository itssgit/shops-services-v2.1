package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.ActionTransLogDTO;

import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public interface ActionTransLogRepositoryCustom {

    ActionTransLogDTO addActionTransLog(ActionTransLogDTO actionTransLogDTO);

    ActionTransLogDTO updateActionTransLog(ActionTransLogDTO actionTransLogDTO);

    Integer deleteActionTransLog(Integer actionTransLogID);

    ActionTransLogDTO getActionTransLogDTOById(Integer actionTransLogID);

    List<ActionTransLogDTO> getActionTransLog();

}

