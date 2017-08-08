package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.StockTransDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface StockTransService {

    StockTransDTO add(StockTransDTO stockTransDTO);

    StockTransDTO update(StockTransDTO stockTransDTO);

    Integer delete(Integer stockTransId);

    List<StockTransDTO> find();

    StockTransDTO findById(Integer stockTransId);
}
