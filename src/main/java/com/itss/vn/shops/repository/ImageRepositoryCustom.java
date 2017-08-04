package com.itss.vn.shops.repository;

import com.itss.vn.shops.dto.ImageDTO;

import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public interface ImageRepositoryCustom {

    ImageDTO addImage(ImageDTO nguyenLieuDTO);

    ImageDTO updateImage(ImageDTO nguyenLieuDTO);

    Integer deleteImage(Integer nguyenLieuID);

    ImageDTO getImageDTOById(Integer nguyenLieuID);

    List<ImageDTO> getImage();

}

