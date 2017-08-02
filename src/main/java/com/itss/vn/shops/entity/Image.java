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
 * Image generated by hbm2java
 */
@Entity
@Table(name = "image", catalog = "shops")
public class Image implements java.io.Serializable {

	private Integer imageId;
	private int imageName;
	private String imageUrl;
	private String objectId;
	private String tableId;
	private Integer status;
	private Date createdTime;
	private Date updatedTime;

	public Image() {
	}

	public Image(int imageName, String imageUrl, String objectId, String tableId) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.objectId = objectId;
		this.tableId = tableId;
	}

	public Image(int imageName, String imageUrl, String objectId, String tableId, Integer status, Date createdTime,
			Date updatedTime) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.objectId = objectId;
		this.tableId = tableId;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "image_id", unique = true, nullable = false)
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	@Column(name = "image_name", nullable = false)
	public int getImageName() {
		return this.imageName;
	}

	public void setImageName(int imageName) {
		this.imageName = imageName;
	}

	@Column(name = "image_url", nullable = false, length = 20)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "object_id", nullable = false, length = 20)
	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	@Column(name = "table_id", nullable = false, length = 20)
	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
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
