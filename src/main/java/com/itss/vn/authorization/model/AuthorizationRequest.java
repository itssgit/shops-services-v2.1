package com.itss.vn.authorization.model;

import java.io.Serializable;

import com.itss.vn.common.exception.BadRequestException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8481779966431460099L;
	
	private String userName;
	
	private String passWord;
	
	public void validate() {
		if(userName == null || passWord == null)
			throw new BadRequestException("Invalid credentials");
		
		if(userName.equals("") || passWord.equals(""))
			throw new BadRequestException("Invalid credentials");
	}

}
