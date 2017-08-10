package com.itss.vn.shops.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 08-Aug-17.
 * Owner By Anhvv
 * DTO giao dich kho
 */
public class StockTransDTO implements Serializable {

    private Integer stockTransId;
    private String stockTransNo;
    private Integer typeTrans;
    private Date createdTime;
    private float totalPromotion;
    private float totalVat;
    private float totalPrice;
    private String staffCode;
    private Integer status;
    private Date updatedTime;

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

    public Integer getTypeTrans() {
        return typeTrans;
    }

    public void setTypeTrans(Integer typeTrans) {
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
}
