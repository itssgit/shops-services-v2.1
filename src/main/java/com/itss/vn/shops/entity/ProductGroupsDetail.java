package com.itss.vn.shops.entity;
// Generated Aug 31, 2017 9:41:01 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * ProductGroupsDetail generated by hbm2java
 */
@Entity
@Table(name = "product_groups_detail", catalog = "shops")
public class ProductGroupsDetail implements java.io.Serializable {

    private Integer id;
    private String productGroupsDesc;
    private int groupId;
    private int productId;
    private String staffCodeCreate;
    private String staffCodeUpdate;
    private Integer status;
    private Date updatedTime;
    private Date createdTime;

    public ProductGroupsDetail() {
    }

    public ProductGroupsDetail(int id, int groupId, int productId, String staffCodeCreate, String staffCodeUpdate) {
        this.id = id;
        this.groupId = groupId;
        this.productId = productId;
        this.staffCodeCreate = staffCodeCreate;
        this.staffCodeUpdate = staffCodeUpdate;
    }

    public ProductGroupsDetail(int id, String productGroupsDesc, int groupId, int productId, String staffCodeCreate,
                               String staffCodeUpdate, Integer status, Date updatedTime, Date createdTime) {
        this.id = id;
        this.productGroupsDesc = productGroupsDesc;
        this.groupId = groupId;
        this.productId = productId;
        this.staffCodeCreate = staffCodeCreate;
        this.staffCodeUpdate = staffCodeUpdate;
        this.status = status;
        this.updatedTime = updatedTime;
        this.createdTime = createdTime;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "product_groups_desc")
    public String getProductGroupsDesc() {
        return this.productGroupsDesc;
    }

    public void setProductGroupsDesc(String productGroupsDesc) {
        this.productGroupsDesc = productGroupsDesc;
    }

    @Column(name = "group_id", nullable = false)
    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
