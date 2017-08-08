package com.itss.vn.shops.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 08-Aug-17.
 * OwnerBy anhvu
 * DTO chi tiet giao dich kho
 */
public class StockTransDetailDTO implements Serializable {

    private Integer stockTransDetailId;
    private int inventoryId;
    private int quantity;
    private float vat;
    private float promotion;
    private float unitPrice;
    private int stockTransId;
    private Integer status;
    private Date createdTime;
    private Date updatedTime;

    public StockTransDetailDTO() {
    }

    public Integer getStockTransDetailId() {
        return stockTransDetailId;
    }

    public void setStockTransDetailId(Integer stockTransDetailId) {
        this.stockTransDetailId = stockTransDetailId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public float getPromotion() {
        return promotion;
    }

    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockTransId() {
        return stockTransId;
    }

    public void setStockTransId(int stockTransId) {
        this.stockTransId = stockTransId;
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
