package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.ActionTransLogDetailDTO;

import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public interface ActionTransLogDetailRepositoryCustom {

    ActionTransLogDetailDTO addActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDetailDTO);

    ActionTransLogDetailDTO updateActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDetailDTO);

    Integer deleteActionTransLogDetail(Integer actionTransLogDetailID);

    ActionTransLogDetailDTO getActionTransLogDetailDTOById(Integer actionTransLogDetailID);

    List<ActionTransLogDetailDTO> getActionTransLogDetail();

}

