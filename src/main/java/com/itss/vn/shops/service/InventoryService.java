package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.InventoryDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Interface quan ly kho
 */
public interface InventoryService {

    InventoryDTO addStock(InventoryDTO inventoryDTO);

    InventoryDTO updateStock(InventoryDTO inventoryDTO);

    Integer deleteStock(Integer inventoryID);

    List<InventoryDTO> getListStock();

    InventoryDTO getStockDTOById(Integer inventoryID);
}
