package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.OptionSetValueDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface OptionSetValueService {

    OptionSetValueDTO add(OptionSetValueDTO optionSetValueDTO);

    OptionSetValueDTO update(OptionSetValueDTO optionSetValueDTO);

    Integer delete(Integer optionSetId);

    List<OptionSetValueDTO> find();

    OptionSetValueDTO findById(Integer optionSetId);
}
