package com.agenda.api.exception;

public class WebServiceAccessException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebServiceAccessException(){
		super("error");
	}
	
	public WebServiceAccessException(String msg){
		super(msg);
	}
}
