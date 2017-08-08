package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.InventoryDTO;

import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public interface InventoryRepositoryCustom {

    InventoryDTO addInventory(InventoryDTO inventoryDTO);

    InventoryDTO updateInventory(InventoryDTO inventoryDTO);

    Integer deleteInventory(Integer inventoryID);

    InventoryDTO getInventoryDTOById(Integer inventoryID);

    List<InventoryDTO> getInventory();

}

