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

/**
 * StockTransDetail generated by hbm2java
 */
@Entity
@Table(name = "stock_trans_detail", catalog = "shops")
public class StockTransDetail implements java.io.Serializable {

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

	public StockTransDetail() {
	}

	public StockTransDetail(int inventoryId, int quatity, float vat, float promotion, float unitPrice,
			int stockTransId) {
		this.inventoryId = inventoryId;
		this.quantity = quatity;
		this.vat = vat;
		this.promotion = promotion;
		this.unitPrice = unitPrice;
		this.stockTransId = stockTransId;
	}

	public StockTransDetail(int inventoryId, int quatity, float vat, float promotion, float unitPrice, int stockTransId,
			Integer status, Date createdTime, Date updatedTime) {
		this.inventoryId = inventoryId;
		this.quantity = quatity;
		this.vat = vat;
		this.promotion = promotion;
		this.unitPrice = unitPrice;
		this.stockTransId = stockTransId;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "stock_trans_detail_id", unique = true, nullable = false)
	public Integer getStockTransDetailId() {
		return this.stockTransDetailId;
	}

	public void setStockTransDetailId(Integer stockTransDetailId) {
		this.stockTransDetailId = stockTransDetailId;
	}

	@Column(name = "inventory_id", nullable = false)
	public int getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "vat", nullable = false, precision = 12, scale = 0)
	public float getVat() {
		return this.vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	@Column(name = "promotion", nullable = false, precision = 12, scale = 0)
	public float getPromotion() {
		return this.promotion;
	}

	public void setPromotion(float promotion) {
		this.promotion = promotion;
	}

	@Column(name = "unit_price", nullable = false, precision = 12, scale = 0)
	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "stock_trans_id", nullable = false)
	public int getStockTransId() {
		return this.stockTransId;
	}

	public void setStockTransId(int stockTransId) {
		this.stockTransId = stockTransId;
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
