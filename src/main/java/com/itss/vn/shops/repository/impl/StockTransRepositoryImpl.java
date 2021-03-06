package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.StockTransDTO;
import com.itss.vn.shops.entity.StockTrans;
import com.itss.vn.shops.repository.StockTransRepository;
import com.itss.vn.shops.repository.custom.StockTransRepositoryCustom;
import com.itss.vn.shops.repository.predicate.StockTransPredicate;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
        stockTransDTO.setCreatedTime(new Date());
        stockTransDTO.setUpdatedTime(new Date());
        stockTransDTO.setStockTransNo(DataUtils.genCode(Constants.CODE_PREFIX.STOCK_TRANS, repository.getMaxId()));
        StockTrans stockTrans = modelMapper.map(stockTransDTO, StockTrans.class);
        repository.saveAndFlush(stockTrans);
        return modelMapper.map(stockTrans, StockTransDTO.class);
    }

    @Override
    public StockTransDTO update(StockTransDTO stockTransDTO) {
        StockTrans stockTrans = modelMapper.map(stockTransDTO, StockTrans.class);
        StockTrans stockTransUpdate = repository.findOne(stockTransDTO.getStockTransId());
        if (stockTransUpdate.getStockTransId() != null) {
            stockTrans.setCreatedTime(stockTransUpdate.getCreatedTime());
            stockTrans.setUpdatedTime(new Date());
            repository.saveAndFlush(stockTrans);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
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
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return stockTrans.getStockTransId();
    }

    @Override
    public StockTransDTO findById(Integer id) {
        StockTrans stockTrans = repository.findOne(id);
        if (stockTrans == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
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

    @Override
    public StockTransDTO findByCode(String stockTransNo) {
        Predicate where = StockTransPredicate.findByCode(stockTransNo);
        StockTrans stockTrans = repository.findOne(where);
        if (stockTrans == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(stockTrans, StockTransDTO.class);
    }

    @Override
    public List<StockTransDTO> findByCondition(String stockTransNo, String typeTrans, Date startDate, Date endDate) {
        PageRequest pageRequest = DataUtils.getPageRequest(0, 100, "stockTransId", Constants.DESCENDING);
        Predicate where = StockTransPredicate.findByCondition(stockTransNo, typeTrans, startDate, endDate);

        Page<StockTrans> pages = repository.findAll(where, pageRequest);
        List<StockTrans> stockTransList = pages.getContent();

        List<StockTransDTO> result = new ArrayList<>();
        if (pages.getTotalElements() > 0) {
            for (StockTrans stockTrans : stockTransList) {
                StockTransDTO stockTransDTO = modelMapper.map(stockTrans, StockTransDTO.class);
                result.add(stockTransDTO);
            }
        }
        return result;
    }
}
