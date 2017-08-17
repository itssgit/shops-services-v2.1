package com.itss.vn.shops.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * DTO quan ly cau hinh
 */
public class OptionSetDTO implements Serializable {
    private Integer optionSetId;
    private String optionSetCode;
    private String optionSetDesc;
    private String staffCode;
    private Integer status;
    private Date createdTime;
    private Date updatedTime;

    private List<OptionSetValueDTO> optionSetValueDTOList;

    public OptionSetDTO() {
    }

    public Integer getOptionSetId() {
        return optionSetId;
    }

    public void setOptionSetId(Integer optionSetId) {
        this.optionSetId = optionSetId;
    }

    public String getOptionSetCode() {
        return optionSetCode;
    }

    public void setOptionSetCode(String optionSetCode) {
        this.optionSetCode = optionSetCode;
    }

    public String getOptionSetDesc() {
        return optionSetDesc;
    }

    public void setOptionSetDesc(String optionSetDesc) {
        this.optionSetDesc = optionSetDesc;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<OptionSetValueDTO> getOptionSetValueDTOList() {
        return optionSetValueDTOList;
    }

    public void setOptionSetValueDTOList(List<OptionSetValueDTO> optionSetValueDTOList) {
        this.optionSetValueDTOList = optionSetValueDTOList;
    }
}
