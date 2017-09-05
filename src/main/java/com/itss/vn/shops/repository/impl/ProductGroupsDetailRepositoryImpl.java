package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.shops.dto.ProductGroupsDetailDTO;
import com.itss.vn.shops.entity.ProductGroupsDetail;
import com.itss.vn.shops.repository.ProductGroupsDetailRepository;
import com.itss.vn.shops.repository.custom.ProductGroupsDetailRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class ProductGroupsDetailRepositoryImpl implements ProductGroupsDetailRepositoryCustom {

    @Autowired
    private ProductGroupsDetailRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductGroupsDetailDTO add(ProductGroupsDetailDTO productGroupsDetailDTO) {
        productGroupsDetailDTO.setCreatedTime(new Date());
        productGroupsDetailDTO.setUpdatedTime(new Date());
        ProductGroupsDetail ProductGroupsDetail = modelMapper.map(productGroupsDetailDTO, ProductGroupsDetail.class);
        repository.saveAndFlush(ProductGroupsDetail);
        return modelMapper.map(ProductGroupsDetail, ProductGroupsDetailDTO.class);
    }

    @Override
    public ProductGroupsDetailDTO update(ProductGroupsDetailDTO productGroupsDetailDTO) {
        ProductGroupsDetail ProductGroupsDetail = modelMapper.map(productGroupsDetailDTO, ProductGroupsDetail.class);
        ProductGroupsDetail ProductGroupsDetailUpdate = repository.findOne(productGroupsDetailDTO.getId());
        if (ProductGroupsDetailUpdate.getId() != null) {
            ProductGroupsDetail.setCreatedTime(ProductGroupsDetailUpdate.getCreatedTime());
            ProductGroupsDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(ProductGroupsDetail);
        } else {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(ProductGroupsDetail, ProductGroupsDetailDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        ProductGroupsDetail ProductGroupsDetail = repository.findOne(id);
        if (ProductGroupsDetail.getId() != null) {
            ProductGroupsDetail.setStatus(Constants.STATUS.DELETE);
            ProductGroupsDetail.setUpdatedTime(new Date());
            repository.saveAndFlush(ProductGroupsDetail);
        } else {
            throw new RestException("Record doesn't exist");
        }
        return ProductGroupsDetail.getId();
    }

    @Override
    public ProductGroupsDetailDTO findById(Integer id) {
        ProductGroupsDetail ProductGroupsDetail = repository.findOne(id);
        if (ProductGroupsDetail == null) {
            throw new RestException("Record doesn't exist");
        }

        return modelMapper.map(ProductGroupsDetail, ProductGroupsDetailDTO.class);
    }

    @Override
    public List<ProductGroupsDetailDTO> find() {
        List<ProductGroupsDetail> ProductGroupsDetailList = repository.findAll();
        List<ProductGroupsDetailDTO> result = new ArrayList<>();
        if (ProductGroupsDetailList.size() > 0) {
            for (ProductGroupsDetail ProductGroupsDetail : ProductGroupsDetailList) {
                ProductGroupsDetailDTO productGroupsDetailDTO = modelMapper.map(ProductGroupsDetail, ProductGroupsDetailDTO.class);
                result.add(productGroupsDetailDTO);
            }
        }
        return result;
    }
}
