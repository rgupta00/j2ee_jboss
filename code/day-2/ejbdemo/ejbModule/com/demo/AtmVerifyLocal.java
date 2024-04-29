package com.demo;

import javax.ejb.Local;

@Local
public interface AtmVerifyLocal {
	public boolean isValid(String cardNumber);
}
