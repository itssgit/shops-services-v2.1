package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.OptionSetValueDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface OptionSetValueRepositoryCustom {

    OptionSetValueDTO add (OptionSetValueDTO optionSetValueDTO);

    OptionSetValueDTO update(OptionSetValueDTO optionSetValueDTO);

    Integer deleteOptionSetValue(Integer id);

    OptionSetValueDTO findById(Integer id);

    List<OptionSetValueDTO> find();
}
