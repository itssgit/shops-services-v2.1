package com.itss.vn.shops.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itss.vn.common.utils.SSBeanUtils;
import com.itss.vn.shops.entity.Account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AccountDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -67025080562512918L;
	
	private Integer id;
	
	private String userName;
	
	private String fullName;
	
	private String phoneNumber;
	
	private String email;
	
	private String avatar;
	
	public AccountDTO (Account account) {
		super();
		SSBeanUtils.copyPropertiesIgnoreNull(account, this);
	}
	
}
