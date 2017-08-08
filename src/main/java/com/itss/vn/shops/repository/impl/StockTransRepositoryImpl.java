package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.StockTransDTO;
import com.itss.vn.shops.entity.StockTrans;
import com.itss.vn.shops.repository.StockTransRepository;
import com.itss.vn.shops.repository.custom.StockTransRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class StockTransRepositoryImpl implements StockTransRepositoryCustom {

    @Autowired
    private StockTransRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockTransDTO add(StockTransDTO stockTransDTO) {
        StockTrans stockTrans = modelMapper.map(stockTransDTO, StockTrans.class);
        repository.saveAndFlush(stockTrans);
        return modelMapper.map(stockTrans, StockTransDTO.class);
    }

    @Override
    public StockTransDTO update(StockTransDTO stockTransDTO) {
        StockTrans stockTrans = modelMapper.map(stockTransDTO, StockTrans.class);
        StockTrans stockTransUpdate = repository.findOne(stockTransDTO.getStockTransId());
        if (stockTransUpdate.getStockTransId() != null) {
            repository.saveAndFlush(stockTrans);
        } else {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(stockTrans, StockTransDTO.class);
    }

    @Override
    public Integer deleteStockTrans (Integer id) {
        StockTrans stockTrans = repository.findOne(id);
        if (stockTrans.getStockTransId() != null) {
            stockTrans.setStatus(Constants.STATUS.DELETE);
            stockTrans.setUpdatedTime(new Date());
            repository.saveAndFlush(stockTrans);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return stockTrans.getStockTransId();
    }

    @Override
    public StockTransDTO findById(Integer id) {
        StockTrans stockTrans = repository.findOne(id);
        if (stockTrans == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(stockTrans, StockTransDTO.class);
    }

    @Override
    public List<StockTransDTO> find() {
        List<StockTrans> stockTransList = repository.findAll();
        List<StockTransDTO> result = new ArrayList<>();
        if (stockTransList.size() > 0) {
            for (StockTrans stockTrans : stockTransList) {
                StockTransDTO stockTransDTO = modelMapper.map(stockTrans, StockTransDTO.class);
                result.add(stockTransDTO);
            }
        }
        return result;
    }
}
