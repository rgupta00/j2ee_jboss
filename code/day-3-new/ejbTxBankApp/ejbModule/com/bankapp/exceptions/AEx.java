package com.bankapp.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=false)
public class AEx extends Exception{
	private static final long serialVersionUID = 1L;

	public AEx(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
