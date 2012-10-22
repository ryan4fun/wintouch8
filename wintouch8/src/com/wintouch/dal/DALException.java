package com.wintouch.dal;

public class DALException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public DALException(String message, Throwable e){
		
		super(message,e);
	}
	
	public DALException(String message){
		
		super(message);
	}
}
