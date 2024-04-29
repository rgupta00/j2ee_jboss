package com.demo;

import javax.ejb.Stateless;

@Stateless
public class AtmVerify implements AtmVerifyRemote, AtmVerifyLocal {

    public AtmVerify() { }
    
    public boolean isValid(String cardNumber) {
    	Integer val= Integer.parseInt(cardNumber);
    	return val%2==0;
    }

}
