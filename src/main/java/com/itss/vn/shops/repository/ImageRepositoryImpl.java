package com.itss.vn.shops.repository;


import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.ImageDTO;
import com.itss.vn.shops.entity.Image;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hungdd-cadpro on 29/06/2017.
 */
public class ImageRepositoryImpl implements ImageRepositoryCustom {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ImageDTO addImage(ImageDTO imageDTO) {
        Image image = modelMapper.map(imageDTO, Image.class);
        imageRepository.saveAndFlush(image);

        return modelMapper.map(image, ImageDTO.class);
    }

    @Override
    public ImageDTO updateImage(ImageDTO imageDTO) {
        Image image = modelMapper.map(imageDTO, Image.class);

        Image imageUpdate = imageRepository.findOne(imageDTO.getImageId());
        if (imageUpdate.getImageId() != null) {
            imageUpdate = image;
            imageRepository.saveAndFlush(image);
        } else throw new RestException("Record doesn't exist");

        return modelMapper.map(imageUpdate, ImageDTO.class);
    }

    @Override
    public Integer deleteImage(Integer imageID) {
        Image image = imageRepository.findOne(imageID);
        if (image.getImageId() != null) {
            image.setStatus(1);
            image.setUpdatedTime(new Date());
            imageRepository.saveAndFlush(image);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return image.getImageId();
    }

    @Override
    public ImageDTO getImageDTOById(Integer imageID) {
        Image image = imageRepository.findOne(imageID);

        if (image == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(image, ImageDTO.class);
    }

    @Override
    public List<ImageDTO> getImage() {
        List<Image> imageList = imageRepository.findAll();

        List<ImageDTO> result = new ArrayList<>();
        if (imageList.size() > 0) {
            for (Image image : imageList) {
                ImageDTO imageDTO = modelMapper.map(image, ImageDTO.class);
                result.add(imageDTO);
            }
        }
        return result;
    }
}
