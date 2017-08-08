package com.itss.vn.shops.dto;

import java.util.Date;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * DTO quan ly kho
 */
public class InventoryDTO implements java.io.Serializable  {

    private Integer inventoryId;
    private String inventoryCode;
    private int quantity;
    private int quotaNo;
    private float unitPrice;
    private String unit;
    private Integer inventoryType;
    private String inventoryName;
    private String inventoryDesc;
    private Integer status;
    private Date createdTime;
    private Date updatedTime;

    public InventoryDTO() {
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuotaNo() {
        return quotaNo;
    }

    public void setQuotaNo(int quotaNo) {
        this.quotaNo = quotaNo;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryDesc() {
        return inventoryDesc;
    }

    public void setInventoryDesc(String inventoryDesc) {
        this.inventoryDesc = inventoryDesc;
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
