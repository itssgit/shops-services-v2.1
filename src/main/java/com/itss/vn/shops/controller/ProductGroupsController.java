package com.itss.vn.shops.controller;

import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.ProductGroupsDTO;
import com.itss.vn.shops.service.ProductGroupsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@RestController
@Slf4j
@RequestMapping("/productGroups")
public class ProductGroupsController {

    @Autowired
    ProductGroupsService productGroupsService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<ProductGroupsDTO> add(@RequestBody @Valid final ProductGroupsDTO productGroupsDTO) {
        CommonResponse<ProductGroupsDTO> response = new CommonResponse<>();
        ProductGroupsDTO addedDTO = new ProductGroupsDTO();
        try {
            addedDTO = productGroupsService.addProductGroups(productGroupsDTO);
            response.successfulRespone(addedDTO);
        } catch (Exception ex) {
            response.failedRespone(addedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<ProductGroupsDTO> update(@RequestBody @Valid final ProductGroupsDTO productGroupsDTO) {
        CommonResponse<ProductGroupsDTO> response = new CommonResponse<>();
        ProductGroupsDTO updatedDTO = new ProductGroupsDTO();
        try {
            updatedDTO = productGroupsService.updateProductGroups(productGroupsDTO);
            response.successfulRespone(updatedDTO);
        } catch (Exception ex) {
            response.failedRespone(updatedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<ProductGroupsDTO> findById(@RequestParam(value = "productGroupsId", required = true, defaultValue = "0") int productGroupsId) {
        CommonResponse<ProductGroupsDTO> response = new CommonResponse<>();
        ProductGroupsDTO resultDTO = new ProductGroupsDTO();
        try {
            resultDTO = productGroupsService.getProductGroupsDTOById(productGroupsId);
            response.successfulRespone(resultDTO);
        } catch (RestException ex) {
            response.failedRespone(resultDTO, ex.getMessage());
        }

        return response;
    }
}
