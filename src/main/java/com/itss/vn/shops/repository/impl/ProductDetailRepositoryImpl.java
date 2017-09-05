package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.ProductDetailDTO;
import com.itss.vn.shops.entity.ProductDetail;
import com.itss.vn.shops.repository.ProductDetailRepository;
import com.itss.vn.shops.repository.custom.ProductDetailRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class ProductDetailRepositoryImpl implements ProductDetailRepositoryCustom {


    @Autowired
    private ProductDetailRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDetailDTO add(ProductDetailDTO productDetailDTO) {
        productDetailDTO.setCreatedTime(new Date());
        productDetailDTO.setUpdatedTime(new Date());
        ProductDetail productDetail = modelMapper.map(productDetailDTO, ProductDetail.class);
        repository.saveAndFlush(productDetail);
        return modelMapper.map(productDetail, ProductDetailDTO.class);
    }

    @Override
    public ProductDetailDTO update(ProductDetailDTO productDetailDTO) {
        ProductDetail productDetail = modelMapper.map(productDetailDTO, ProductDetail.class);
        ProductDetail productDetailUpdate = repository.findOne(productDetailDTO.getId());
        if (productDetailUpdate.getId() != null) {
            productDetail.setCreatedTime(productDetailUpdate.getCreatedTime());
            productDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(productDetail);
        } else {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(productDetail, ProductDetailDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        ProductDetail productDetail = repository.findOne(id);
        if (productDetail.getId() != null) {
            productDetail.setStatus(Constants.STATUS.DELETE);
            productDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(productDetail);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return productDetail.getId();
    }

    @Override
    public ProductDetailDTO findById(Integer id) {
        ProductDetail productDetail = repository.findOne(id);
        if (productDetail == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(productDetail, ProductDetailDTO.class);
    }

    @Override
    public List<ProductDetailDTO> find() {
        List<ProductDetail> productDetailList = repository.findAll();
        List<ProductDetailDTO> result = new ArrayList<>();
        if (productDetailList.size() > 0) {
            for (ProductDetail productDetail : productDetailList) {
                ProductDetailDTO productDetailDTO = modelMapper.map(productDetail, ProductDetailDTO.class);
                result.add(productDetailDTO);
            }
        }
        return result;
    }
}
