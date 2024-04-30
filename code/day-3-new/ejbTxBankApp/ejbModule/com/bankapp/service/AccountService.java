package com.bankapp.service;

import java.util.List;

import javax.ejb.Remote;

import com.bankapp.dao.Account;
import com.bankapp.exceptions.AEx;
@Remote
public interface AccountService {
	public List<Account> getAll();
	public Account getById(int id);
	public void transfer(int fromAccId, int toAccId, double amount) throws AEx;
	public void deposit(int accId, double amount);
	public void withdraw(int accId, double amount);
	public void addAccount(Account account);
}
