package com.itss.vn.shops.controller;

import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.InventoryDTO;
import com.itss.vn.shops.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * Controller quan ly kho
 */

@RestController
@Slf4j
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<InventoryDTO> addImage(@RequestBody @Valid final InventoryDTO inventoryDTO) {
        CommonResponse<InventoryDTO> response = new CommonResponse<>();
        InventoryDTO addedDTO = new InventoryDTO();
        try {
            addedDTO = inventoryService.addStock(inventoryDTO);
            response.successfulRespone(addedDTO);
        } catch (Exception ex) {
            response.failedRespone(addedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<InventoryDTO> updateImage(@RequestBody @Valid final InventoryDTO inventoryDTO) {
        CommonResponse<InventoryDTO> response = new CommonResponse<>();
        InventoryDTO updatedDTO = new InventoryDTO();
        try {
            updatedDTO = inventoryService.updateStock(inventoryDTO);
            response.successfulRespone(updatedDTO);
        } catch (Exception ex) {
            response.failedRespone(updatedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<InventoryDTO> getUsers(@RequestParam(value = "imageId", required = true, defaultValue = "0") int stockId) {
        CommonResponse<InventoryDTO> response = new CommonResponse<>();
        InventoryDTO resultDTO = new InventoryDTO();
        try {
            resultDTO = inventoryService.getStockDTOById(stockId);
            response.successfulRespone(resultDTO);
        } catch (Exception ex) {
            response.failedRespone(resultDTO, ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<List<InventoryDTO>> getImage() {
        List<InventoryDTO> results = inventoryService.getListStock();
        CommonResponse<List<InventoryDTO>> response = new CommonResponse<>();
        response.successfulRespone(results);
        return response;
    }
}
