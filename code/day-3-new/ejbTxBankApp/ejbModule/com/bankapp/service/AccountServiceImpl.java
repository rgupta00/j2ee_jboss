package com.bankapp.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
import com.bankapp.exceptions.*;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AccountServiceImpl implements AccountService{

	
	@EJB
	private AccountDao accountDao;
	
	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		return accountDao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void transfer(int fromAccId, int toAccId, double amount) throws AEx{
		Account fromAcc=getById(fromAccId);
		Account toAcc=getById(toAccId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		accountDao.updateAccount(fromAcc);
		if(1==1)
			throw new AEx("some run time ex");
		
		accountDao.updateAccount(toAcc);
		
	}

	@Override
	public void deposit(int accId, double amount) {
		Account acc=getById(accId);
		acc.setBalance(acc.getBalance()+amount);
		accountDao.updateAccount(acc);
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account acc=getById(accId);
		acc.setBalance(acc.getBalance()-amount);
		accountDao.updateAccount(acc);
	}

	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

}
