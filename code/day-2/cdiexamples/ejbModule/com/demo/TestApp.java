package com.demo;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Singleton
@Startup
public class TestApp {

	@Inject
	@Other
	private MyAlgo myAlgo;
	
	@PostConstruct
	public void test() {
		System.out.println("---------------------------");
		System.out.println(myAlgo.calculation());
		System.out.println("---------------------------");
	}
	
}
