package com.itss.vn.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -1369947388623925839L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time", length = 19)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time", length = 19)
	private Date updatedTime;

	@PrePersist
	public void prePersist() {
		createdTime = updatedTime = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		updatedTime = new Date();
	}

}
