package com.cg.customerjparest.exception;

public class InvalidCustomerIdException extends RuntimeException{
	public InvalidCustomerIdException() {		
	}
	
	public InvalidCustomerIdException(String msg) {
		super(msg);
	}
}
