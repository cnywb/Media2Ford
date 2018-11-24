package com.agenda.api.exception;

public class ActionAccessException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionAccessException(){
		super("error");
	}
	
	public ActionAccessException(String msg){
		super(msg);
	}
}
