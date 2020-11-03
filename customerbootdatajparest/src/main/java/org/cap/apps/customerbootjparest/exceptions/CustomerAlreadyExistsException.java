package org.cap.apps.customerbootjparest.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
	 public CustomerAlreadyExistsException(){

	    }

	    public CustomerAlreadyExistsException(String msg){
	        super(msg);
	    }

}
