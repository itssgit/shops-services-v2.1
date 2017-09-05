package com.itss.vn.shops.service.impl;

import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.ProductDTO;
import com.itss.vn.shops.repository.ProductRepository;
import com.itss.vn.shops.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        if (productDTO.getProductId() == null || productDTO.getProductId() == 0) {
            productDTO.setProductId(null);
            return productRepository.add(productDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (productDTO.getProductId() != null) {
            return productRepository.update(productDTO);
        } else {
            throw new BadRequestException(Errors.ERROR_BAD_REQUEST_EMPTY);
        }
    }

    @Override
    public Integer deleteProduct(Integer productID) {
        return productRepository.deleteById(productID);
    }

    @Override
    public List<ProductDTO> getListProduct() {
        return productRepository.find();
    }

    @Override
    public ProductDTO getProductDTOById(Integer productID) {
        return productRepository.findById(productID);
    }

    @Override
    public List<ProductDTO> getListProductByCondition(String productCode, String productName, Integer productType, Integer productStatus, String sortBy, String sortOrder) {
        return null;
    }
}
