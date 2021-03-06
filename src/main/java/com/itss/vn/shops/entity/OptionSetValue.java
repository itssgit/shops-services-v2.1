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
 * OptionSetValue generated by hbm2java
 */
@Entity
@Table(name = "option_set_value", catalog = "shops")
public class OptionSetValue implements java.io.Serializable {

	private Integer optionSetValueId;
	private int optionSetId;
	private String optionSetName;
	private String optionSetValue;
	private String staffCode;
	private Integer status;
	private Date createdTime;
	private Date updatedTime;

	public OptionSetValue() {
	}

	public OptionSetValue(int optionSetId, String optionSetName, String optionSetValue, String staffCode) {
		this.optionSetId = optionSetId;
		this.optionSetName = optionSetName;
		this.optionSetValue = optionSetValue;
		this.staffCode = staffCode;
	}

	public OptionSetValue(int optionSetId, String optionSetName, String optionSetValue, String staffCode,
			Integer status, Date createdTime, Date updatedTime) {
		this.optionSetId = optionSetId;
		this.optionSetName = optionSetName;
		this.optionSetValue = optionSetValue;
		this.staffCode = staffCode;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "option_set_value_id", unique = true, nullable = false)
	public Integer getOptionSetValueId() {
		return this.optionSetValueId;
	}

	public void setOptionSetValueId(Integer optionSetValueId) {
		this.optionSetValueId = optionSetValueId;
	}

	@Column(name = "option_set_id", nullable = false)
	public int getOptionSetId() {
		return this.optionSetId;
	}

	public void setOptionSetId(int optionSetId) {
		this.optionSetId = optionSetId;
	}

	@Column(name = "option_set_name", nullable = false, length = 20)
	public String getOptionSetName() {
		return this.optionSetName;
	}

	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}

	@Column(name = "option_set_value", nullable = false, length = 20)
	public String getOptionSetValue() {
		return this.optionSetValue;
	}

	public void setOptionSetValue(String optionSetValue) {
		this.optionSetValue = optionSetValue;
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
