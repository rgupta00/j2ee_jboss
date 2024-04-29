package com.demo;

import javax.ejb.Remote;

@Remote
public interface AtmVerifyRemote {
	public boolean isValid(String cardNumber);
}
