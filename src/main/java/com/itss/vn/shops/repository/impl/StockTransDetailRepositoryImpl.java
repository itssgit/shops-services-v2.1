package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.StockTransDetailDTO;
import com.itss.vn.shops.entity.StockTransDetail;
import com.itss.vn.shops.repository.StockTransDetailRepository;
import com.itss.vn.shops.repository.custom.StockTransDetailRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class StockTransDetailRepositoryImpl implements StockTransDetailRepositoryCustom {

    @Autowired
    private StockTransDetailRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockTransDetailDTO add(StockTransDetailDTO stockTransDetailDTO) {
        StockTransDetail stockTransDetail = modelMapper.map(stockTransDetailDTO, StockTransDetail.class);
        repository.saveAndFlush(stockTransDetail);
        return modelMapper.map(stockTransDetail, StockTransDetailDTO.class);
    }

    @Override
    public StockTransDetailDTO update(StockTransDetailDTO stockTransDetailDTO) {
        StockTransDetail stockTransDetail = modelMapper.map(stockTransDetailDTO, StockTransDetail.class);
        StockTransDetail stockTransDetailUpdate = repository.findOne(stockTransDetailDTO.getStockTransDetailId());
        if (stockTransDetailUpdate.getStockTransDetailId() != null) {
            repository.saveAndFlush(stockTransDetail);
        } else {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(stockTransDetail, StockTransDetailDTO.class);
    }

    @Override
    public Integer deleteStockTransDetail (Integer id) {
        StockTransDetail stockTransDetail = repository.findOne(id);
        if (stockTransDetail.getStockTransDetailId() != null) {
            stockTransDetail.setStatus(Constants.STATUS.DELETE);
            stockTransDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(stockTransDetail);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return stockTransDetail.getStockTransId();
    }

    @Override
    public StockTransDetailDTO findById(Integer id) {
        StockTransDetail stockTransDetail = repository.findOne(id);
        if (stockTransDetail == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(stockTransDetail, StockTransDetailDTO.class);

    }

    @Override
    public List<StockTransDetailDTO> find() {
        List<StockTransDetail> stockTransDetailList = repository.findAll();
        List<StockTransDetailDTO> result = new ArrayList<>();
        if (stockTransDetailList.size() > 0) {
            for (StockTransDetail stockTransDetail : stockTransDetailList) {
                StockTransDetailDTO stockTransDetailDTO = modelMapper.map(stockTransDetail, StockTransDetailDTO.class);
                result.add(stockTransDetailDTO);
            }
        }
        return result;
    }
}
