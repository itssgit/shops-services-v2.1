package com.itss.vn.shops.entity;
// Generated Aug 2, 2017 4:33:40 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Inventory generated by hbm2java
 */
@Entity
@Table(name = "inventory", catalog = "shops", uniqueConstraints = @UniqueConstraint(columnNames = "inventory_code"))
public class Inventory implements java.io.Serializable {

	private Integer inventoryId;
	private String inventoryCode;
	private int quantity;
	private int quotaNo;
	private String unit;
	private Integer inventoryType;
	private String inventoryName;
	private String inventoryDesc;
	private Integer status;
	private Date createdTime;
	private Date updatedTime;

	public Inventory() {
	}

	public Inventory(String inventoryCode, int quantity, int quotaNo, String unit, String inventoryName,
			String inventoryDesc) {
		this.inventoryCode = inventoryCode;
		this.quantity = quantity;
		this.quotaNo = quotaNo;
		this.unit = unit;
		this.inventoryName = inventoryName;
		this.inventoryDesc = inventoryDesc;
	}

	public Inventory(String inventoryCode, int quantity, int quotaNo, String unit, Integer inventoryType,
			String inventoryName, String inventoryDesc, Integer status, Date createdTime, Date updatedTime) {
		this.inventoryCode = inventoryCode;
		this.quantity = quantity;
		this.quotaNo = quotaNo;
		this.unit = unit;
		this.inventoryType = inventoryType;
		this.inventoryName = inventoryName;
		this.inventoryDesc = inventoryDesc;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "inventory_id", unique = true, nullable = false)
	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@Column(name = "inventory_code", unique = true, nullable = false, length = 20)
	public String getInventoryCode() {
		return this.inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "quota_no", nullable = false)
	public int getQuotaNo() {
		return this.quotaNo;
	}

	public void setQuotaNo(int quotaNo) {
		this.quotaNo = quotaNo;
	}

	@Column(name = "unit", nullable = false, length = 20)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "inventory_type")
	public Integer getInventoryType() {
		return this.inventoryType;
	}

	public void setInventoryType(Integer inventoryType) {
		this.inventoryType = inventoryType;
	}

	@Column(name = "inventory_name", nullable = false, length = 50)
	public String getInventoryName() {
		return this.inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	@Column(name = "inventory_desc", nullable = false)
	public String getInventoryDesc() {
		return this.inventoryDesc;
	}

	public void setInventoryDesc(String inventoryDesc) {
		this.inventoryDesc = inventoryDesc;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time", length = 19)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time", length = 19)
	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

}
