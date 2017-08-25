package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.StockTransDTO;
import com.itss.vn.shops.dto.StockTransDetailDTO;
import com.itss.vn.shops.repository.StockTransRepository;
import com.itss.vn.shops.service.InventoryService;
import com.itss.vn.shops.service.StockTransDetailService;
import com.itss.vn.shops.service.StockTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private InventoryService inventoryService;


    @Override
    @Transactional
    public StockTransDTO add(StockTransDTO stockTransDTO) {
        StockTransDTO resultDTO;
        if (stockTransDTO.getStockTransId() == null || stockTransDTO.getStockTransId() == 0) {
            stockTransDTO.setStockTransId(null);
            resultDTO = repository.add(stockTransDTO);

            List<StockTransDetailDTO> stockTransDetailDTOList = new ArrayList<>();

            for (StockTransDetailDTO stockTransDetailDTO : stockTransDTO.getStockTransDetailDTOList()) {
                stockTransDetailDTO.setStatus(Constants.STATUS.AVAILABLE);

                if (resultDTO.getStatus() == Constants.STATUS.AVAILABLE) {
                    //update inventory
                    inventoryService.adjustStock(stockTransDetailDTO.getInventoryId(),
                            stockTransDetailDTO.getQuantity(),
                            stockTransDetailDTO.getUnitPrice(),
                            stockTransDTO.getTypeTrans());
                }
                stockTransDetailDTO.setStockTransId(resultDTO.getStockTransId());
                StockTransDetailDTO addedDTO = stockTransDetailService.add(stockTransDetailDTO);
                stockTransDetailDTOList.add(addedDTO);
            }

            resultDTO.setStockTransDetailDTOList(stockTransDetailDTOList);

        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
        return resultDTO;
    }


    @Override
    @Transactional
    public StockTransDTO update(StockTransDTO stockTransDTO) {
        if (stockTransDTO.getStockTransId() != null) {

            //delete stockTransDetail khong co trong list
            List<StockTransDetailDTO> stockTransDetailDTOS = stockTransDetailService.findByStockTransId(stockTransDTO.getStockTransId(), Constants.STATUS.AVAILABLE);

            //List<stockTransDetailDTO> listDelete = new ArrayList<>();
            stockTransDetailDTOS.forEach(stockTransDetailDTO -> {
                Boolean isDelete = true;
                for (StockTransDetailDTO tmpDTO : stockTransDTO.getStockTransDetailDTOList()) {
                    if (stockTransDetailDTO.getStockTransDetailId() == tmpDTO.getStockTransDetailId()
                            && stockTransDetailDTO.getStockTransDetailId() != null
                            && stockTransDetailDTO.getStockTransDetailId() != 0) {
                        isDelete = false;
                        break;
                    }
                }

                if (isDelete) {
                    if (stockTransDetailDTO.getStockTransDetailId() != null && stockTransDetailDTO.getStockTransDetailId() != 0)
                        stockTransDetailService.delete(stockTransDetailDTO.getStockTransDetailId());
                }
            });

            //add or update chi tiet co trong list
            stockTransDTO.setStockTransDetailDTOList(
                    stockTransDetailService.updateListStockTransDetail(
                            stockTransDTO.getStockTransDetailDTOList(), stockTransDTO.getStockTransId()));

            //update stock_trans -> update inventory
            if (stockTransDTO.getStatus() == Constants.STATUS.AVAILABLE) {
                for (StockTransDetailDTO tmpDTO : stockTransDTO.getStockTransDetailDTOList()) {
                    inventoryService.adjustStock(tmpDTO.getInventoryId(),
                            tmpDTO.getQuantity(),
                            tmpDTO.getUnitPrice(),
                            stockTransDTO.getTypeTrans());
                }
            }

            StockTransDTO resultDTO = repository.update(stockTransDTO);
            resultDTO.setStockTransDetailDTOList(stockTransDetailService.findByStockTransId(stockTransDTO.getStockTransId(), Constants.STATUS.AVAILABLE));

            return resultDTO;
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer delete(Integer id) {
        if (id != null) {
            return repository.deleteStockTrans(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }

    }


    @Override
    public List<StockTransDTO> find() {
        return repository.find();
    }

    @Override
    public StockTransDTO findById(Integer id) {
        if (id != null) {
            return repository.findById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public StockTransDTO getStockTransByCode(String stockTransNo) {
        StockTransDTO stockTransDTO;

        if (stockTransNo.isEmpty()) {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        } else {
            stockTransDTO = repository.findByCode(stockTransNo);
            stockTransDTO.setStockTransDetailDTOList(
                    stockTransDetailService.findByStockTransId(
                            stockTransDTO.getStockTransId(),
                            Constants.STATUS.AVAILABLE));
        }

        return stockTransDTO;
    }

    @Override
    @Transactional
    public StockTransDTO insertOrUpdate(StockTransDTO stockTransDTO) {
        StockTransDTO resultDTO;
        if (stockTransDTO.getStockTransId() == null || stockTransDTO.getStockTransId() == 0) {
            resultDTO = this.add(stockTransDTO);
        } else {
            resultDTO = this.update(stockTransDTO);
        }
        return resultDTO;
    }

    @Override
    public List<StockTransDTO> findByCondition(String stockTransNo, String typeTrans, Date startDate, Date endDate) {
        return null;
    }
}
