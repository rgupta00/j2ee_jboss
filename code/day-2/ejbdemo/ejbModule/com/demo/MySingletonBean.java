package com.demo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton //only one object of ejb
@Startup //hey container create the sigleton bean in advance
//singleton bean may have race condition : concurrency issues
public class MySingletonBean {
	//is to test other ejb
	
	@EJB
	private AtmVerifyLocal atmVerifyLocal;
	
	@EJB
	private ShoppingCounter shoppingCounter;
	//try to do jndi mapping
	//java:jboss/exported/ejbdemo/AtmVerify!com.demo.AtmVerifyRemote
	
	@PostConstruct
	public void test() {
		System.out.println("---------------------------------");
		//System.out.println(atmVerifyLocal.isValid("465454"));
		
		shoppingCounter.increment();
		System.out.println(shoppingCounter.getCounter());
		
		System.out.println("---------------------------------");
	}
	

}
