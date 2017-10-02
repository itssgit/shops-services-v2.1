package com.itss.vn.shops.repository.impl;

import com.itss.vn.common.constant.Constants;
import com.itss.vn.common.constant.Errors;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.DataUtils;
import com.itss.vn.shops.dto.ProductGroupsDTO;
import com.itss.vn.shops.entity.ProductGroups;
import com.itss.vn.shops.repository.ProductGroupsRepository;
import com.itss.vn.shops.repository.custom.ProductGroupsRepositoryCustom;
import com.itss.vn.shops.repository.predicate.ProductGroupsPredicate;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public class ProductGroupsRepositoryImpl implements ProductGroupsRepositoryCustom {

    @Autowired
    private ProductGroupsRepository productGroupsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductGroupsDTO add(ProductGroupsDTO productGroupsDTO) {
        productGroupsDTO.setCreatedTime(new Date());
        productGroupsDTO.setUpdatedTime(new Date());
        String code = DataUtils.genCode(Constants.CODE_PREFIX.PRODUCT_GROUP, productGroupsRepository.getMaxId());
        productGroupsDTO.setGroupCode(code);
        ProductGroups productGroups = modelMapper.map(productGroupsDTO, ProductGroups.class);
        productGroupsRepository.saveAndFlush(productGroups);

        return modelMapper.map(productGroups, ProductGroupsDTO.class);
    }

    @Override
    public ProductGroupsDTO update(ProductGroupsDTO productGroupsDTO) {
        ProductGroups productGroups = modelMapper.map(productGroupsDTO, ProductGroups.class);

        ProductGroups productGroupsUpdate = productGroupsRepository.findOne(productGroupsDTO.getGroupId());
        if (productGroupsUpdate.getGroupId() != null) {
            productGroups.setCreatedTime(productGroupsUpdate.getCreatedTime());
            productGroups.setUpdatedTime(new Date());
            productGroupsRepository.saveAndFlush(productGroups);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(productGroups, ProductGroupsDTO.class);
    }

    @Override
    public Integer deleteById(Integer id) {
        ProductGroups productGroups = productGroupsRepository.findOne(id);
        if (productGroups.getGroupId() != null) {
            productGroups.setStatus(0);
            productGroups.setUpdatedTime(new Date());
            productGroupsRepository.saveAndFlush(productGroups);
        } else {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }
        return productGroups.getGroupId();
    }

    @Override
    public ProductGroupsDTO findById(Integer id) {
        ProductGroups productGroups = productGroupsRepository.findOne(id);

        if (productGroups == null) {
            throw new RestException(Errors.ERROR_NOT_EXIST_RECORD_CODE, Errors.ERROR_NOT_EXIST_RECORD_MSG);
        }

        return modelMapper.map(productGroups, ProductGroupsDTO.class);
    }

    @Override
    public List<ProductGroupsDTO> find() {
        List<ProductGroups> productGroupsList = productGroupsRepository.findAll();

        List<ProductGroupsDTO> result = new ArrayList<>();
        if (productGroupsList.size() > 0) {
            for (ProductGroups productGroups : productGroupsList) {
                ProductGroupsDTO productGroupsDTO = modelMapper.map(productGroups, ProductGroupsDTO.class);
                result.add(productGroupsDTO);
            }
        }
        return result;
    }

    @Override
    public List<ProductGroupsDTO> getListProductGroupsDTOByCondition(String groupsCode, Integer status, String groupsName, String parentCode) {
        PageRequest pageRequest = DataUtils.getPageRequest(0, 1000, "groupId", Constants.DESCENDING);
        Predicate where = ProductGroupsPredicate.findByCondition(groupsCode, status, groupsName);

        Page<ProductGroups> productGroupsPage = productGroupsRepository.findAll(where, pageRequest);
        List<ProductGroups> productGroupsList = productGroupsPage.getContent();

        List<ProductGroupsDTO> result = new ArrayList<>();
        if (productGroupsList.size() > 0) {
            for (ProductGroups productGroups : productGroupsList) {
                ProductGroupsDTO productGroupsDTO = modelMapper.map(productGroups, ProductGroupsDTO.class);
                result.add(productGroupsDTO);
            }
        }
        return result;
    }
}
