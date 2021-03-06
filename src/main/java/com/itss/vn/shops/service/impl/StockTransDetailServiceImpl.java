package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.StockTransDetailDTO;
import com.itss.vn.shops.repository.StockTransDetailRepository;
import com.itss.vn.shops.service.InventoryService;
import com.itss.vn.shops.service.StockTransDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@Service
public class StockTransDetailServiceImpl implements StockTransDetailService {

    @Autowired
    private StockTransDetailRepository repository;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public StockTransDetailDTO add(StockTransDetailDTO stockTransDetailDTO) {
        if (stockTransDetailDTO.getStockTransDetailId() == null || stockTransDetailDTO.getStockTransDetailId() == 0) {
            stockTransDetailDTO.setStockTransDetailId(null);
            return repository.add(stockTransDetailDTO);
        } else {
            throw new BadRequestException("");
        }
    }


    @Override
    public StockTransDetailDTO update(StockTransDetailDTO stockTransDetailDTO) {
        if (stockTransDetailDTO.getStockTransDetailId() != null) {
            return repository.update(stockTransDetailDTO);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public Integer delete(Integer id) {
        if (id != null) {
            return repository.deleteStockTransDetail(id);
        } else {
            throw new BadRequestException("");
        }
    }


    @Override
    public List<StockTransDetailDTO> find() {
        return repository.find();
    }

    @Override
    public StockTransDetailDTO findById(Integer id) {
        if (id != null) {
            return repository.findById(id);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public List<StockTransDetailDTO> findByStockTransId(Integer stockTransId, Integer status) {
        List<StockTransDetailDTO> stockTransDetailDTOList = repository.findByStockTransId(stockTransId, status);

        stockTransDetailDTOList.forEach(stockTransDetailDTO -> {
            stockTransDetailDTO.setInventoryDTO(inventoryService.getStockDTOById(stockTransDetailDTO.getInventoryId()));
        });

        return stockTransDetailDTOList;
    }

    @Override
    public List<StockTransDetailDTO> updateListStockTransDetail(List<StockTransDetailDTO> stockTransDetailDTOList, Integer stockTransId) {
        List<StockTransDetailDTO> listDTO = new ArrayList<>();
        for (StockTransDetailDTO tmpDTO : stockTransDetailDTOList) {
            tmpDTO.setUpdatedTime(new Date());
            tmpDTO.setStockTransId(stockTransId);
            if (tmpDTO.getStockTransDetailId() == null || tmpDTO.getStockTransDetailId() == 0) {
                StockTransDetailDTO insertDTO = this.add(tmpDTO);
                listDTO.add(insertDTO);
            } else {
                StockTransDetailDTO updatedDTO = this.update(tmpDTO);
                listDTO.add(updatedDTO);
            }
        }
        return listDTO;
    }
}
