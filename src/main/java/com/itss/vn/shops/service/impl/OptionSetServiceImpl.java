package com.itss.vn.shops.service.impl;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.dto.OptionSetDTO;
import com.itss.vn.shops.entity.OptionSet;
import com.itss.vn.shops.repository.ImageRepository;
import com.itss.vn.shops.repository.OptionSetRepository;
import com.itss.vn.shops.service.OptionSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
@Service
public class OptionSetServiceImpl implements OptionSetService {

    @Autowired
    private OptionSetRepository optionSetRepository;

    @Override
    public OptionSetDTO add(OptionSetDTO optionSetDTO) {
        if (optionSetDTO.getOptionSetId() == null || optionSetDTO.getOptionSetId() == 0) {
            optionSetDTO.setOptionSetId(null);
            return optionSetRepository.add(optionSetDTO);
        } else {
            throw new BadRequestException("Cấu hình đã tồn tại.");
        }
    }


    @Override
    public OptionSetDTO update(OptionSetDTO optionSetDTO) {
        if (optionSetDTO.getOptionSetId() != null) {
            return optionSetRepository.update(optionSetDTO);
        } else {
            throw new BadRequestException("Không tìm thấy id của cấu hình");
        }
    }

    @Override
    public Integer delete(Integer optionSetId) {
        if(optionSetId != null){
            return optionSetRepository.deleteOptionSet(optionSetId);
        } else {
            throw new BadRequestException("Không tìm thấy id của cấu hình");
        }

    }


    @Override
    public List<OptionSetDTO> find() {
        return optionSetRepository.find();
    }

    @Override
    public OptionSetDTO findById(Integer optionSetId) {
        if(optionSetId != null) {
            return optionSetRepository.findById(optionSetId);
        } else {
            throw new BadRequestException("Không tìm thấy id của cấu hình");
        }
    }
}
