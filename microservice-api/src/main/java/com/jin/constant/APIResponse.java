package com.jin.constant;

import java.io.Serializable;

import lombok.Data;
@Data

public class APIResponse<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	
	private String code;
	
	private T result;
}
