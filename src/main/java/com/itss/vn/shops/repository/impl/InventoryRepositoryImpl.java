package com.itss.vn.shops.repository.impl;


import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.InventoryDTO;
import com.itss.vn.shops.entity.Inventory;
import com.itss.vn.shops.repository.InventoryRepository;
import com.itss.vn.shops.repository.custom.InventoryRepositoryCustom;
import com.itss.vn.shops.repository.predicate.InventoryPredicate;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public class InventoryRepositoryImpl implements InventoryRepositoryCustom {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InventoryDTO addInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = modelMapper.map(inventoryDTO, Inventory.class);
        inventoryRepository.saveAndFlush(inventory);

        return modelMapper.map(inventory, InventoryDTO.class);
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = modelMapper.map(inventoryDTO, Inventory.class);

        Inventory inventoryUpdate = inventoryRepository.findOne(inventoryDTO.getInventoryId());
        if (inventoryUpdate.getInventoryId() != null) {
            inventoryUpdate = inventory;
            inventoryRepository.saveAndFlush(inventory);
        } else throw new RestException("Record doesn't exist");

        return modelMapper.map(inventoryUpdate, InventoryDTO.class);
    }

    @Override
    public Integer deleteInventory(Integer inventoryID) {
        Inventory inventory = inventoryRepository.findOne(inventoryID);
        if (inventory.getInventoryId() != null) {
            inventory.setStatus(0);
            inventory.setUpdatedTime(new Date());
            inventoryRepository.saveAndFlush(inventory);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return inventory.getInventoryId();
    }

    @Override
    public InventoryDTO getInventoryDTOById(Integer inventoryID) {
        Inventory inventory = inventoryRepository.findOne(inventoryID);

        if (inventory == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(inventory, InventoryDTO.class);
    }

    @Override
    public List<InventoryDTO> getInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();

        List<InventoryDTO> result = new ArrayList<>();
        if (inventoryList.size() > 0) {
            for (Inventory inventory : inventoryList) {
                InventoryDTO inventoryDTO = modelMapper.map(inventory, InventoryDTO.class);
                result.add(inventoryDTO);
            }
        }
        return result;
    }

    @Override
    public List<InventoryDTO> getListStockByCondition(String inventoryCode, String inventoryName, Integer inventoryType, Integer inventoryStatus, String sortBy, String sortOrder) {
        PageRequest pageRequest = DataUtils.getPageRequest(0, 100, sortBy, sortOrder);
        Predicate where = InventoryPredicate.findInventory(inventoryCode, inventoryName, inventoryType, inventoryStatus);
        Page<Inventory> inventoryPage = inventoryRepository.findAll(where, pageRequest);

        List<Inventory> inventoryList = inventoryPage.getContent();
        List<InventoryDTO> result = new ArrayList<>();
        if (inventoryPage.getTotalElements() > 0) {
            for (Inventory inventory : inventoryList) {
                InventoryDTO inventoryDTO = modelMapper.map(inventory, InventoryDTO.class);
                result.add(inventoryDTO);
            }
        }

        return result;
    }
}
