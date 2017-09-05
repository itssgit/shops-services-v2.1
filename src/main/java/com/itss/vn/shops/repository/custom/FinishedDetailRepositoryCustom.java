package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.FinishedDetailDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface FinishedDetailRepositoryCustom {

    FinishedDetailDTO add(FinishedDetailDTO finishedDetailDTO);

    FinishedDetailDTO update(FinishedDetailDTO finishedDetailDTO);

    Integer deleteById(Integer id);

    FinishedDetailDTO findById(Integer id);

    List<FinishedDetailDTO> find();
}
