package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.InventoryDTO;
import com.itss.vn.shops.repository.InventoryRepository;
import com.itss.vn.shops.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Service Impl quan ly kho
 */

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public InventoryDTO addStock(InventoryDTO inventoryDTO) {
        if (inventoryDTO.getInventoryId() == null || inventoryDTO.getInventoryId() == 0) {
            inventoryDTO.setInventoryId(null);
            return inventoryRepository.addInventory(inventoryDTO);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public InventoryDTO updateStock(InventoryDTO inventoryDTO) {
        if (inventoryDTO.getInventoryId() != null) {
            return inventoryRepository.updateInventory(inventoryDTO);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public Integer deleteStock(Integer inventoryID) {
        return inventoryRepository.deleteInventory(inventoryID);
    }

    @Override
    public List<InventoryDTO> getListStock() {
        return inventoryRepository.getInventory();
    }

    @Override
    public InventoryDTO getStockDTOById(Integer inventoryID) {
        return inventoryRepository.getInventoryDTOById(inventoryID);
    }               
}
