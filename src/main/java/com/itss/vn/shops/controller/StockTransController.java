package com.itss.vn.shops.controller;

import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.StockTransDTO;
import com.itss.vn.shops.service.StockTransService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@RestController
@Slf4j
@RequestMapping("/stockTrans")
public class StockTransController {

    @Autowired
    StockTransService stockTransService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<StockTransDTO> add(@RequestBody @Valid final StockTransDTO stockTransDTO) {
        CommonResponse<StockTransDTO> response = new CommonResponse<>();
        StockTransDTO addedDTO = new StockTransDTO();
        try {
            addedDTO = stockTransService.add(stockTransDTO);
            response.successfulRespone(addedDTO);
        } catch (RestException ex) {
            response.failedRespone(addedDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<StockTransDTO> addOrUpdate(@RequestBody @Valid final StockTransDTO stockTransDTO) {
        CommonResponse<StockTransDTO> response = new CommonResponse<>();
        StockTransDTO resultDTO = new StockTransDTO();
        try {
            resultDTO = stockTransService.insertOrUpdate(stockTransDTO);
            response.successfulRespone(resultDTO);
        } catch (RestException ex) {
            response.failedRespone(resultDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<StockTransDTO> update(@RequestBody @Valid final StockTransDTO stockTransDTO) {
        CommonResponse<StockTransDTO> response = new CommonResponse<>();
        StockTransDTO updatedDTO = new StockTransDTO();
        try {
            updatedDTO = stockTransService.update(stockTransDTO);
            response.successfulRespone(updatedDTO);
        } catch (RestException ex) {
            response.failedRespone(updatedDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<StockTransDTO> findById(@RequestParam(value = "stockTransId", required = true, defaultValue = "0") int stockTransId) {
        CommonResponse<StockTransDTO> response = new CommonResponse<>();
        StockTransDTO resultDTO = new StockTransDTO();
        try {
            resultDTO = stockTransService.findById(stockTransId);
            response.successfulRespone(resultDTO);
        } catch (RestException ex) {
            response.failedRespone(resultDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<List<StockTransDTO>> find() {
        List<StockTransDTO> results = stockTransService.find();
        CommonResponse<List<StockTransDTO>> response = new CommonResponse<>();
        response.successfulRespone(results);
        return response;
    }

    @RequestMapping(value = "/findByCode", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<StockTransDTO> findByCode(@RequestParam(value = "stockTransNo", required = true, defaultValue = "") String stocKTransNo) {
        CommonResponse<StockTransDTO> response = new CommonResponse<>();
        StockTransDTO resultDTO = new StockTransDTO();

        try {
            resultDTO = stockTransService.getStockTransByCode(stocKTransNo);
            response.successfulRespone(resultDTO);
        } catch (RestException ex) {
            response.failedRespone(resultDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }

        return response;
    }
}
