package com.itss.vn.common.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8876674163414273243L;
	
	private int code;
	
	private String message;

}
