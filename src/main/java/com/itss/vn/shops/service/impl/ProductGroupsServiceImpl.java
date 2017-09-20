package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.ProductGroupsDTO;
import com.itss.vn.shops.repository.ProductGroupsRepository;
import com.itss.vn.shops.service.ProductGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGroupsServiceImpl implements ProductGroupsService {

    @Autowired
    ProductGroupsRepository productGroupsRepository;


    @Override
    public ProductGroupsDTO addProductGroups(ProductGroupsDTO productGroupsDTO) {
        if (productGroupsDTO.getGroupId() == null || productGroupsDTO.getGroupId() == 0) {
            productGroupsDTO.setGroupId(null);
            return productGroupsRepository.add(productGroupsDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public ProductGroupsDTO updateProductGroups(ProductGroupsDTO productGroupsDTO) {
        if (productGroupsDTO.getGroupId() != null) {
            return productGroupsRepository.update(productGroupsDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer deleteProductGroups(Integer id) {
        if (id != null) {
            return productGroupsRepository.deleteById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }


    @Override
    public ProductGroupsDTO getProductGroupsDTOById(Integer id) {
        if (id != null) {
            return productGroupsRepository.findById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }
}
