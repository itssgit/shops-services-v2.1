package com.itss.vn.shops.dto;
// Generated Aug 2, 2017 4:33:40 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.List;

/**
 * ActionTransLog generated by hbm2java
 */
public class ActionTransLogDTO implements java.io.Serializable {

	private Integer actionTransLogId;
	private String actionCode;
	private String actionName;
	private String staffCode;
	private Date createdTime;

	private List<ActionTransLogDetailDTO> actionTransLogDetailDTOList;


	public Integer getActionTransLogId() {
		return actionTransLogId;
	}

	public void setActionTransLogId(Integer actionTransLogId) {
		this.actionTransLogId = actionTransLogId;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
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

	public List<ActionTransLogDetailDTO> getActionTransLogDetailDTOList() {
		return actionTransLogDetailDTOList;
	}

	public void setActionTransLogDetailDTOList(List<ActionTransLogDetailDTO> actionTransLogDetailDTOList) {
		this.actionTransLogDetailDTOList = actionTransLogDetailDTOList;
	}
}
