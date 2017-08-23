package com.itss.vn.shops.controller;

import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.StockTransDetailDTO;
import com.itss.vn.shops.entity.StockTransDetail;
import com.itss.vn.shops.service.StockTransDetailService;
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
@RequestMapping("/stockTransDetail")
public class StockTransDetailController {

    @Autowired
    StockTransDetailService stockTransDetailService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<StockTransDetailDTO> add(@RequestBody @Valid final StockTransDetailDTO stockTransDetailDTO) {
        CommonResponse<StockTransDetailDTO> response = new CommonResponse<>();
        StockTransDetailDTO addedDTO = new StockTransDetailDTO();
        try {
            addedDTO = stockTransDetailService.add(stockTransDetailDTO);
            response.successfulRespone(addedDTO);
        } catch (RestException ex) {
            response.failedRespone(addedDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<StockTransDetailDTO> update(@RequestBody @Valid final StockTransDetailDTO stockTransDetailDTO) {
        CommonResponse<StockTransDetailDTO> response = new CommonResponse<>();
        StockTransDetailDTO updatedDTO = new StockTransDetailDTO();
        try {
            updatedDTO = stockTransDetailService.update(stockTransDetailDTO);
            response.successfulRespone(updatedDTO);
        } catch (RestException ex) {
            response.failedRespone(updatedDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<StockTransDetailDTO> findById(@RequestParam(value = "stockTransDetailId", required = true, defaultValue = "0") int stockTransDetailId) {
        CommonResponse<StockTransDetailDTO> response = new CommonResponse<>();
        StockTransDetailDTO resultDTO = new StockTransDetailDTO();
        try {
            resultDTO = stockTransDetailService.findById(stockTransDetailId);
            response.successfulRespone(resultDTO);
        } catch (RestException ex) {
            response.failedRespone(resultDTO, String.valueOf(ex.getCode()), ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<List<StockTransDetailDTO>> find() {
        List<StockTransDetailDTO> results = stockTransDetailService.find();
        CommonResponse<List<StockTransDetailDTO>> response = new CommonResponse<>();
        response.successfulRespone(results);
        return response;
    }
}
