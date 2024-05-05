package com.bankapp;

import javax.xml.ws.WebFault;

@WebFault(name="InvalidCardException")
public class InvalidCardException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidCardException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
