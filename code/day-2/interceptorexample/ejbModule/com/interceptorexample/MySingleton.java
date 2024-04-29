package com.interceptorexample;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class MySingleton {
	
	@Inject
	private MyBean bean;
	
	
	@PostConstruct
	public void test() {
		bean.hi();
	}

}
