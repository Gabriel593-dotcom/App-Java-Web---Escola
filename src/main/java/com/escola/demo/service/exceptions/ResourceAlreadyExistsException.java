package com.escola.demo.service.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceAlreadyExistsException() {
		super("Resource already registered in System."); 
	}

}
