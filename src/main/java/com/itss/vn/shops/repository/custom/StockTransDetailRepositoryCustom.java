package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.StockTransDetailDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface StockTransDetailRepositoryCustom {

    StockTransDetailDTO add (StockTransDetailDTO stockTransDetailDTO);

    StockTransDetailDTO update(StockTransDetailDTO stockTransDetailDTO);

    Integer deleteStockTransDetail(Integer id);

    StockTransDetailDTO findById(Integer id);

    List<StockTransDetailDTO> find();

    List<StockTransDetailDTO> findByStockTransId(Integer stockTransId);
}
