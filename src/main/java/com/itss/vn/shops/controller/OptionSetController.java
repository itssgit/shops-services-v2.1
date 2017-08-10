package com.itss.vn.shops.controller;

import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.OptionSetDTO;
import com.itss.vn.shops.service.OptionSetService;
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
@RequestMapping("/optionSet")
public class OptionSetController {
    @Autowired
    OptionSetService optionSetService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<OptionSetDTO> add(@RequestBody @Valid final OptionSetDTO optionSetDTO) {
        CommonResponse<OptionSetDTO> response = new CommonResponse<>();
        OptionSetDTO addedDTO = new OptionSetDTO();
        try {
            addedDTO = optionSetService.add(optionSetDTO);
            response.successfulRespone(addedDTO);
        } catch (Exception ex) {
            response.failedRespone(addedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<OptionSetDTO> update(@RequestBody @Valid final OptionSetDTO optionSetDTO) {
        CommonResponse<OptionSetDTO> response = new CommonResponse<>();
        OptionSetDTO updatedDTO = new OptionSetDTO();
        try {
            updatedDTO = optionSetService.update(optionSetDTO);
            response.successfulRespone(updatedDTO);
        } catch (Exception ex) {
            response.failedRespone(updatedDTO, ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<OptionSetDTO> findById(@RequestParam(value = "optionSetId", required = true, defaultValue = "0") int optionSetId) {
        CommonResponse<OptionSetDTO> response = new CommonResponse<>();
        OptionSetDTO resultDTO = new OptionSetDTO();
        try {
            resultDTO = optionSetService.findById(optionSetId);
            response.successfulRespone(resultDTO);
        } catch (Exception ex) {
            response.failedRespone(resultDTO, ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<List<OptionSetDTO>> find() {
        List<OptionSetDTO> results = optionSetService.find();
        CommonResponse<List<OptionSetDTO>> response = new CommonResponse<>();
        response.successfulRespone(results);
        return response;
    }
}
