package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.StockTransDTO;
import com.itss.vn.shops.dto.StockTransDetailDTO;
import com.itss.vn.shops.repository.StockTransRepository;
import com.itss.vn.shops.service.StockTransDetailService;
import com.itss.vn.shops.service.StockTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@Service
public class StockTransServiceImpl implements StockTransService {

    @Autowired
    private StockTransRepository repository;

    @Autowired
    private StockTransDetailService stockTransDetailService;

    @Override
    public StockTransDTO add(StockTransDTO stockTransDTO) {
        StockTransDTO resultDTO = new StockTransDTO();
        if (stockTransDTO.getStockTransId() == null || stockTransDTO.getStockTransId() == 0) {
            stockTransDTO.setStockTransId(null);
            resultDTO = repository.add(stockTransDTO);

            List<StockTransDetailDTO> stockTransDetailDTOList = new ArrayList<>();

            for (StockTransDetailDTO stockTransDetailDTO : stockTransDTO.getStockTransDetailDTOList()) {
                stockTransDetailDTO.setStockTransId(resultDTO.getStockTransId());
                StockTransDetailDTO addedDTO = stockTransDetailService.add(stockTransDetailDTO);
                stockTransDetailDTOList.add(addedDTO);
            }

            resultDTO.setStockTransDetailDTOList(stockTransDetailDTOList);

        } else {
            throw new BadRequestException("");
        }
        return resultDTO;
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

    @Override
    public StockTransDTO getStockTransByCode(String stockTransNo) {
        StockTransDTO stockTransDTO = new StockTransDTO();

        if (stockTransNo.isEmpty()) {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        } else {
            stockTransDTO = repository.findByCode(stockTransNo);
            stockTransDTO.setStockTransDetailDTOList(stockTransDetailService.findByStockTransId(stockTransDTO.getStockTransId()));
        }

        return stockTransDTO;
    }
}
