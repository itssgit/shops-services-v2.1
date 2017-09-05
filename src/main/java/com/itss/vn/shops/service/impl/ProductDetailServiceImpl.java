package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.ProductDetailDTO;
import com.itss.vn.shops.repository.ProductDetailRepository;
import com.itss.vn.shops.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    ProductDetailRepository productDetailRepository;


    @Override
    public ProductDetailDTO addProductDetail(ProductDetailDTO productDetailDTO) {
        if (productDetailDTO.getId() == null || productDetailDTO.getId() == 0) {
            productDetailDTO.setId(null);
            return productDetailRepository.add(productDetailDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public ProductDetailDTO updateProductDetail(ProductDetailDTO productDetailDTO) {
        if (productDetailDTO.getId() != null) {
            return productDetailRepository.update(productDetailDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer deleteProductDetail(Integer id) {
        if (id != null) {
            return productDetailRepository.deleteById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }


    @Override
    public ProductDetailDTO getProductDetailDTOById(Integer id) {
        if (id != null) {
            return productDetailRepository.findById(id);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }
}
