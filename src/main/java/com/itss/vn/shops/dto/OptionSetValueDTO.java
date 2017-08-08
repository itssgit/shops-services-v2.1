package com.itss.vn.shops.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * DTO chi tiet cau hinh
 */
public class OptionSetValueDTO implements Serializable {
    private Integer optionSetValueId;
    private int optionSetId;
    private String optionSetName;
    private String optionSetValue;
    private String staffCode;
    private Integer status;
    private Date createdTime;
    private Date updatedTime;

    public OptionSetValueDTO() {
    }

    public Integer getOptionSetValueId() {
        return optionSetValueId;
    }

    public void setOptionSetValueId(Integer optionSetValueId) {
        this.optionSetValueId = optionSetValueId;
    }

    public int getOptionSetId() {
        return optionSetId;
    }

    public void setOptionSetId(int optionSetId) {
        this.optionSetId = optionSetId;
    }

    public String getOptionSetName() {
        return optionSetName;
    }

    public void setOptionSetName(String optionSetName) {
        this.optionSetName = optionSetName;
    }

    public String getOptionSetValue() {
        return optionSetValue;
    }

    public void setOptionSetValue(String optionSetValue) {
        this.optionSetValue = optionSetValue;
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
}
