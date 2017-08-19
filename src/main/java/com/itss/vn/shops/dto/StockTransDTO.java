package com.itss.vn.shops.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * DTO giao dich kho
 */
public class StockTransDTO implements Serializable {

    private Integer stockTransId;
    private String stockTransNo;
    private String typeTrans;
    private Date createdTime;
    private float totalPromotion;
    private float totalVat;
    private float totalPrice;
    private String staffCode;
    private Integer status;
    private Date updatedTime;
    private List<StockTransDetailDTO> stockTransDetailDTOList;

    public StockTransDTO() {
    }

    public Integer getStockTransId() {
        return stockTransId;
    }

    public void setStockTransId(Integer stockTransId) {
        this.stockTransId = stockTransId;
    }

    public String getStockTransNo() {
        return stockTransNo;
    }

    public void setStockTransNo(String stockTransNo) {
        this.stockTransNo = stockTransNo;
    }

    public String getTypeTrans() {
        return typeTrans;
    }

    public void setTypeTrans(String typeTrans) {
        this.typeTrans = typeTrans;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public float getTotalPromotion() {
        return totalPromotion;
    }

    public void setTotalPromotion(float totalPromotion) {
        this.totalPromotion = totalPromotion;
    }

    public float getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(float totalVat) {
        this.totalVat = totalVat;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<StockTransDetailDTO> getStockTransDetailDTOList() {
        return stockTransDetailDTOList;
    }

    public void setStockTransDetailDTOList(List<StockTransDetailDTO> stockTransDetailDTOList) {
        this.stockTransDetailDTOList = stockTransDetailDTOList;
    }
}
