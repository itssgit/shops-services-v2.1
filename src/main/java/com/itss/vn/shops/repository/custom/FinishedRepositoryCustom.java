package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.FinishedDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface FinishedRepositoryCustom {

    FinishedDTO add(FinishedDTO finishedDTO);

    FinishedDTO update(FinishedDTO finishedDTO);

    Integer deleteById(Integer id);

    FinishedDTO findById(Integer id);

    List<FinishedDTO> find();
}
