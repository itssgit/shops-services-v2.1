package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.ImageDTO;
import com.itss.vn.shops.repository.ImageRepository;
import com.itss.vn.shops.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageDTO addImage(ImageDTO imageDTO) {
        if (imageDTO.getImageId() == null || imageDTO.getImageId() == 0) {
            imageDTO.setImageId(null);
            return imageRepository.addImage(imageDTO);
        } else {
            throw new BadRequestException();
        }
    }


    @Override
    public ImageDTO updateImage(ImageDTO imageDTO) {
        if (imageDTO.getImageId() != null) {
            return imageRepository.updateImage(imageDTO);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public Integer deleteImage(Integer imageID) {
        return imageRepository.deleteImage(imageID);
    }


    @Override
    public List<ImageDTO> getImage() {
        return imageRepository.getImage();
    }

    @Override
    public ImageDTO getImageDTOById(Integer imageID) {


        return imageRepository.getImageDTOById(imageID);
    }

}
