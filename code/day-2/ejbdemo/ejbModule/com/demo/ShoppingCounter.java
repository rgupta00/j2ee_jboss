package com.demo;

import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton(name="shoppingCounter")
@Startup
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value=1000, unit=TimeUnit.SECONDS)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ShoppingCounter {
	
	private int counter;
	
	void postConstruct() {
		counter=0;
	}
	
	//@Lock(LockType.WRITE)
	synchronized int increment() {
		++counter;
		return counter;
	}
	
	//@Lock(LockType.WRITE)
	synchronized int decrement() {
		--counter;
		return counter;
	}
	
	//@Lock(LockType.READ)
	synchronized int getCounter() {
		return counter;
	}

}
