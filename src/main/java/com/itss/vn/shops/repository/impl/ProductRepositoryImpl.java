package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.ProductDTO;
import com.itss.vn.shops.entity.Product;
import com.itss.vn.shops.repository.ProductRepository;
import com.itss.vn.shops.repository.custom.ProductRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO add(ProductDTO productDTO) {
        productDTO.setCreatedTime(new Date());
        productDTO.setUpdatedTime(new Date());
        String code = DataUtils.genCode(Constants.CODE_PREFIX.PRODUCT, productRepository.getMaxId());
        productDTO.setProductCode(code);
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.saveAndFlush(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        Product productUpdate = productRepository.findOne(productDTO.getProductId());
        if (productUpdate.getProductId() != null) {
            product.setCreatedTime(productUpdate.getCreatedTime());
            product.setUpdatedTime(new Date());
            productRepository.saveAndFlush(product);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        Product product = productRepository.findOne(id);
        if (product.getProductId() != null) {
            product.setStatus(0);
            product.setUpdatedTime(new Date());
            productRepository.saveAndFlush(product);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return product.getProductId();
    }

    @Override
    public ProductDTO findById(Integer id) {
        Product product = productRepository.findOne(id);

        if (product == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> find() {
        List<Product> productList = productRepository.findAll();

        List<ProductDTO> result = new ArrayList<>();
        if (productList.size() > 0) {
            for (Product product : productList) {
                ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
                result.add(productDTO);
            }
        }
        return result;
    }
}
