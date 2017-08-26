package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.StockTransDTO;

import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface StockTransRepositoryCustom {

    StockTransDTO add (StockTransDTO stockTransDTO);

    StockTransDTO update(StockTransDTO stockTransDTO);

    Integer deleteStockTrans(Integer id);

    StockTransDTO findById(Integer id);

    List<StockTransDTO> find();

    StockTransDTO findByCode(String stockTransNo);

    List<StockTransDTO> findByCondition(String stockTransNo, String typeTrans, Date startDate, Date endDate);
}
