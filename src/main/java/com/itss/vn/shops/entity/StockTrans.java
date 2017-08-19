package com.itss.vn.shops.entity;
// Generated Aug 2, 2017 4:33:40 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * StockTrans generated by hbm2java
 */
@Entity
@Table(name = "stock_trans", catalog = "shops", uniqueConstraints = @UniqueConstraint(columnNames = "stock_trans_no"))
public class StockTrans implements java.io.Serializable {

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

	public StockTrans() {
	}

	public StockTrans(String stockTransNo, float totalPromotion, float totalVat, float totalPrice, String staffCode) {
		this.stockTransNo = stockTransNo;
		this.totalPromotion = totalPromotion;
		this.totalVat = totalVat;
		this.totalPrice = totalPrice;
		this.staffCode = staffCode;
	}

	public StockTrans(String stockTransNo, String typeTrans, Date createdTime, float totalPromotion, float totalVat,
					  float totalPrice, String staffCode, Integer status, Date updatedTime) {
		this.stockTransNo = stockTransNo;
		this.typeTrans = typeTrans;
		this.createdTime = createdTime;
		this.totalPromotion = totalPromotion;
		this.totalVat = totalVat;
		this.totalPrice = totalPrice;
		this.staffCode = staffCode;
		this.status = status;
		this.updatedTime = updatedTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "stock_trans_id", unique = true, nullable = false)
	public Integer getStockTransId() {
		return this.stockTransId;
	}

	public void setStockTransId(Integer stockTransId) {
		this.stockTransId = stockTransId;
	}

	@Column(name = "stock_trans_no", unique = true, nullable = false, length = 20)
	public String getStockTransNo() {
		return this.stockTransNo;
	}

	public void setStockTransNo(String stockTransNo) {
		this.stockTransNo = stockTransNo;
	}

	@Column(name = "type_trans", nullable = false, length = 3)
	public String getTypeTrans() {
		return this.typeTrans;
	}

	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time", length = 19)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Column(name = "total_promotion", nullable = false, precision = 12, scale = 0)
	public float getTotalPromotion() {
		return this.totalPromotion;
	}

	public void setTotalPromotion(float totalPromotion) {
		this.totalPromotion = totalPromotion;
	}

	@Column(name = "total_vat", nullable = false, precision = 12, scale = 0)
	public float getTotalVat() {
		return this.totalVat;
	}

	public void setTotalVat(float totalVat) {
		this.totalVat = totalVat;
	}

	@Column(name = "total_price", nullable = false, precision = 12, scale = 0)
	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "staff_code", nullable = false, length = 20)
	public String getStaffCode() {
		return this.staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
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

}
