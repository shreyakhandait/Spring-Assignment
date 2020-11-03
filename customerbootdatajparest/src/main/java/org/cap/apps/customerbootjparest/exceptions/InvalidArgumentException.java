package org.cap.apps.customerbootjparest.exceptions;

public class InvalidArgumentException extends RuntimeException{

	public InvalidArgumentException() {
		
	}
	
	public InvalidArgumentException(String msg) {
		super(msg);
	}
}
