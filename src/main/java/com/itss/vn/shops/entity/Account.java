package com.itss.vn.shops.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itss.vn.common.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2359848397910660301L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "user_name", nullable = false, length = 200)
	private String userName;
	
	@Column(name = "pass_word", nullable = false, length = 200)
	private String passWord;
	
	@Column(name = "full_name", length = 200)
	private String fullName;
	
	@Column(name = "phone_number", length = 200)
	private String phoneNumber;
	
	@Column(name = "email", length = 200)
	private String email;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "gender")
	private Integer gender;
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role")
	private Role role;

}
