package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.StockTransDetailDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface StockTransDetailService {

    StockTransDetailDTO add(StockTransDetailDTO StockTransDetailDTO);

    StockTransDetailDTO update(StockTransDetailDTO StockTransDetailDTO);

    Integer delete(Integer stockTransDetailId);

    List<StockTransDetailDTO> find();

    StockTransDetailDTO findById(Integer stockTransDetailId);

    List<StockTransDetailDTO> findByStockTransId(Integer stockTransId, Integer status);

    List<StockTransDetailDTO> updateListStockTransDetail(List<StockTransDetailDTO> stockTransDetailDTOList);

}
