package com.liuawei.spirng.web.exception;

public class BussinessException extends RuntimeException{
	
	private String code;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BussinessException(){
		super();
	}
	
	public BussinessException(String code,String msg){
		super(msg);
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
