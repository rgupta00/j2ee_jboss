package com.logic;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface AtmVerfifyLocal {
	public boolean isValid(String cardNumber);
}
