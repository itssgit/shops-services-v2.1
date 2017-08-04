package com.itss.vn.shops.controller;

import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.ImageDTO;
import com.itss.vn.shops.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<ImageDTO> addImage(@RequestBody @Valid final ImageDTO imageDTO) {
        CommonResponse<ImageDTO> response = new CommonResponse<>();
        ImageDTO addedDTO = new ImageDTO();
        try {
            addedDTO = imageService.addImage(imageDTO);
            response.successfulRespone(addedDTO);
        } catch (Exception ex) {
            response.failedRespone(addedDTO, ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public CommonResponse<ImageDTO> updateImage(@RequestBody @Valid final ImageDTO imageDTO) {
        CommonResponse<ImageDTO> response = new CommonResponse<>();
        ImageDTO updatedDTO = new ImageDTO();
        try {
            updatedDTO = imageService.updateImage(imageDTO);
            response.successfulRespone(updatedDTO);
        } catch (Exception ex) {
            response.failedRespone(updatedDTO, ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<ImageDTO> getUsers(@RequestParam(value = "imageId", required = true, defaultValue = "0") int imageId) {
        CommonResponse<ImageDTO> response = new CommonResponse<>();
        ImageDTO resultDTO = new ImageDTO();
        try {
            resultDTO = imageService.getImageDTOById(imageId);
            response.successfulRespone(resultDTO);
        } catch (Exception ex) {
            response.failedRespone(resultDTO, ex.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public CommonResponse<List<ImageDTO>> getImage() {
        List<ImageDTO> results = imageService.getImage();
        CommonResponse<List<ImageDTO>> response = new CommonResponse<List<ImageDTO>>();
        response.successfulRespone(results);

        return response;
    }

}
