package com.itss.vn.shops.repository.custom;

import com.itss.vn.shops.dto.OptionSetDTO;

import java.util.List;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 */
public interface OptionSetRepositoryCustom {

    OptionSetDTO add (OptionSetDTO optionSetDTO);

    OptionSetDTO update(OptionSetDTO optionSetDTO);

    Integer deleteOptionSet(Integer optionSetId);

    OptionSetDTO findById(Integer OptionSetId);

    List<OptionSetDTO> find();

    OptionSetDTO getOptionSetDTO(String optionSetCode);
}
