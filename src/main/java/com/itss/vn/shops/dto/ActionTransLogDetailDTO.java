package com.itss.vn.shops.dto;
// Generated Aug 2, 2017 4:33:40 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;

/**
 * ActionTransLogDetail generated by hbm2java
 */
public class ActionTransLogDetailDTO implements java.io.Serializable {

	private Integer actionTransLogDetailId;
	private int actionTransLogId;
	private String tableName;
	private String columnName;
	private int columnId;
	private String oldValue;
	private String newValue;
	private String actionDetailDesc;
	private String staffCode;
	private Date createdTime;

	public Integer getActionTransLogDetailId() {
		return actionTransLogDetailId;
	}

	public void setActionTransLogDetailId(Integer actionTransLogDetailId) {
		this.actionTransLogDetailId = actionTransLogDetailId;
	}

	public int getActionTransLogId() {
		return actionTransLogId;
	}

	public void setActionTransLogId(int actionTransLogId) {
		this.actionTransLogId = actionTransLogId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getActionDetailDesc() {
		return actionDetailDesc;
	}

	public void setActionDetailDesc(String actionDetailDesc) {
		this.actionDetailDesc = actionDetailDesc;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}