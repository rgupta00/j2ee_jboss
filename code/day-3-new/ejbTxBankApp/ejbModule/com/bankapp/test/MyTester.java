package com.bankapp.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bankapp.dao.Account;
import com.bankapp.exceptions.AEx;
import com.bankapp.service.AccountService;



@Singleton
@Startup
public class MyTester {


	@EJB
	private AccountService accountService; 
	
	
	@PostConstruct
	public void test() throws AEx {
		System.out.println("------------------------------------");
		//addAccounts();
		accountService.transfer(1, 2, 10);
		System.out.println("------------------------------------------");
	}


	private void addAccounts() {
		accountService.addAccount(new Account("raj", 1000));
		accountService.addAccount(new Account("ekta", 1000));
	}

	
	
}
