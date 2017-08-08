package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ActionTransLogDetailDTO;
import com.itss.vn.shops.entity.ActionTransLogDetail;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Hungdd
 * Service Interface quan ly kho
 */
public interface ActionTransLogDetailService {

    ActionTransLogDetailDTO addActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDTO);

    ActionTransLogDetailDTO updateActionTransLogDetail(ActionTransLogDetailDTO actionTransLogDTO);

    Integer deleteActionTransLogDetail(Integer actionTransLogID);

    List<ActionTransLogDetailDTO> getListActionTransLogDetail();

    ActionTransLogDetailDTO getActionTransLogDetailDTOById(Integer actionTransLogID);

    List<ActionTransLogDetailDTO> addListActionTransLogDetailDTO( List<ActionTransLogDetailDTO> actionTransLogDetailDTOList, Integer ActionTransLogId);
}
