package com.logic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

//Session bean
@Stateless
public class AtmVerfify implements AtmVerfifyRemote,AtmVerfifyLocal  {

	@PostConstruct
	public void postConstruct() {
		System.out.println("before creating the object of ejb");
	}
	@Override
	public boolean isValid(String cardNumber) {
		//Business logic write inside ejb
		Integer val=Integer.parseInt(cardNumber);
		
		return val%2==0;
	}

	@PreDestroy
	public void preDestory() {
		System.out.println("this method is going to be called before preDestory");
	}
}
