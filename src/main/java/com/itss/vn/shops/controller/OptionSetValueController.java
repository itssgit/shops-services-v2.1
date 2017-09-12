package com.itss.vn.shops.controller;

import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.OptionSetValueDTO;
import com.itss.vn.shops.service.OptionSetValueService;
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
@RequestMapping("/optionSetValue")
public class OptionSetValueController {

    @Autowired
    OptionSetValueService optionSetValueService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<OptionSetValueDTO> add(@RequestBody @Valid final OptionSetValueDTO optionSetValueDTO) {
        CommonResponse<OptionSetValueDTO> response = new CommonResponse<>();
        OptionSetValueDTO addedDTO = new OptionSetValueDTO();
        try {
            addedDTO = optionSetValueService.add(optionSetValueDTO);
            response.successfulRespone(addedDTO);
        } catch (Exception ex) {
            response.failedRespone(addedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<OptionSetValueDTO> update(@RequestBody @Valid final OptionSetValueDTO optionSetValueDTO) {
        CommonResponse<OptionSetValueDTO> response = new CommonResponse<>();
        OptionSetValueDTO updatedDTO = new OptionSetValueDTO();
        try {
            updatedDTO = optionSetValueService.update(optionSetValueDTO);
            response.successfulRespone(updatedDTO);
        } catch (Exception ex) {
            response.failedRespone(updatedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<OptionSetValueDTO> findById(@RequestParam(value = "optionSetValueId", required = true, defaultValue = "0") int optionSetValueId) {
        CommonResponse<OptionSetValueDTO> response = new CommonResponse<>();
        OptionSetValueDTO resultDTO = new OptionSetValueDTO();
        try {
            resultDTO = optionSetValueService.findById(optionSetValueId);
            response.successfulRespone(resultDTO);
        } catch (Exception ex) {
            response.failedRespone(resultDTO, ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<List<OptionSetValueDTO>> find() {
        List<OptionSetValueDTO> results = optionSetValueService.find();
        CommonResponse<List<OptionSetValueDTO>> response = new CommonResponse<>();
        response.successfulRespone(results);
        return response;
    }
}
