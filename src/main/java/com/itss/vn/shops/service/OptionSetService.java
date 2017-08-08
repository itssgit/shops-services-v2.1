package com.itss.vn.shops.service;

import com.itss.vn.shops.dto.OptionSetDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface OptionSetService {

    OptionSetDTO add(OptionSetDTO optionSetDTO);

    OptionSetDTO update(OptionSetDTO optionSetDTO);

    Integer delete(Integer optionSetID);

    List<OptionSetDTO> find();

    OptionSetDTO findById(Integer optionSetId);
}
