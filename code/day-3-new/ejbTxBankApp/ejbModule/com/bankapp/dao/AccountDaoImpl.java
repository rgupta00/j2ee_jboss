package com.bankapp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bankapp.exceptions.AccountNotFoundException;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AccountDaoImpl implements AccountDao{

	@PersistenceContext(unitName="bookappEjbJpa")
	private EntityManager em;
	
	@Override
	public List<Account> getAll() {
		return em.createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		Account account=em.find(Account.class, id);
		if(account==null)
			throw new AccountNotFoundException("account with id "+id +" is not found");
		return account;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void updateAccount(Account account) {
			em.merge(account);
	}

	@Override
	public void addAccount(Account account) {
		em.persist(account);
	}

}
