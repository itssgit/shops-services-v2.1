package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.ImageDTO;

import java.util.List;

public interface ImageService {

    ImageDTO addImage(ImageDTO imageDTO);

    ImageDTO updateImage(ImageDTO imageDTO);

    Integer deleteImage(Integer imageID);

    List<ImageDTO> getImage();

    ImageDTO getImageDTOById(Integer imageID);

}
