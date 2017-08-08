package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.StockTransDTO;
import com.itss.vn.shops.repository.StockTransRepository;
import com.itss.vn.shops.service.StockTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@Service
public class StockTransServiceImpl implements StockTransService {

    @Autowired
    private StockTransRepository repository;

    @Override
    public StockTransDTO add(StockTransDTO stockTransDTO) {
        if (stockTransDTO.getStockTransId() == null || stockTransDTO.getStockTransId() == 0) {
            stockTransDTO.setStockTransId(null);
            return repository.add(stockTransDTO);
        } else {
            throw new BadRequestException("");
        }
    }


    @Override
    public StockTransDTO update(StockTransDTO stockTransDTO) {
        if (stockTransDTO.getStockTransId() != null) {
            return repository.update(stockTransDTO);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public Integer delete(Integer id) {
        if(id != null){
            return repository.deleteStockTrans(id);
        } else {
            throw new BadRequestException("");
        }

    }


    @Override
    public List<StockTransDTO> find() {
        return repository.find();
    }

    @Override
    public StockTransDTO findById(Integer id) {
        if(id != null) {
            return repository.findById(id);
        } else {
            throw new BadRequestException("");
        }
    }
}
