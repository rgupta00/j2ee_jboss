package com.logic;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface AtmVerfifyRemote {
	public boolean isValid(String cardNumber);
}
