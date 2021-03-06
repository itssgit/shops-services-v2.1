package com.itss.vn.shops.entity;
// Generated Aug 31, 2017 9:41:01 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "shops", uniqueConstraints = @UniqueConstraint(columnNames = "product_code"))
public class Product implements java.io.Serializable {

    private Integer productId;
    private String productCode;
    private String productName;
    private String productDesc;
    private String staffCodeCreate;
    private String staffCodeUpdate;
    private Integer status;
    private Date updatedTime;
    private Date createdTime;

    public Product() {
    }

    public Product(int productId, String productCode, String productName, String staffCodeCreate,
                   String staffCodeUpdate) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.staffCodeCreate = staffCodeCreate;
        this.staffCodeUpdate = staffCodeUpdate;
    }

    public Product(int productId, String productCode, String productName, String productDesc, String staffCodeCreate,
                   String staffCodeUpdate, Integer status, Date updatedTime, Date createdTime) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.staffCodeCreate = staffCodeCreate;
        this.staffCodeUpdate = staffCodeUpdate;
        this.status = status;
        this.updatedTime = updatedTime;
        this.createdTime = createdTime;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "product_code", unique = true, nullable = false, length = 25)
    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Column(name = "product_name", nullable = false, length = 50)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "product_desc")
    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Column(name = "staff_code_create", nullable = false, length = 20)
    public String getStaffCodeCreate() {
        return this.staffCodeCreate;
    }

    public void setStaffCodeCreate(String staffCodeCreate) {
        this.staffCodeCreate = staffCodeCreate;
    }

    @Column(name = "staff_code_update", nullable = false, length = 20)
    public String getStaffCodeUpdate() {
        return this.staffCodeUpdate;
    }

    public void setStaffCodeUpdate(String staffCodeUpdate) {
        this.staffCodeUpdate = staffCodeUpdate;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time", length = 19)
    public Date getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", length = 19)
    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
