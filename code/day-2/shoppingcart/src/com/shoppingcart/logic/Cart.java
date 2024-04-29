package com.shoppingcart.logic;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class Cart implements CartRemote {
	
    public Cart() {}
    
    private Hashtable<String, Integer> cart;
    
    @PostConstruct
    public void postConstruct() {
    	cart=new Hashtable<>();
    }
    
    @PostActivate
    public void postPassivate() {
    	cart=new Hashtable<>();
    }
    
	@Override
	public void putItem(String itemId, int qty) {
		cart.put(itemId, qty);
	}
	

	@Override
	public void removeItem(String itemId) {
		cart.remove(itemId);
	}

	@Override
	public Hashtable<String, Integer> getItem() {
		return cart;
	}

    @PrePassivate
    public void prePassivate() {
    	cart=null;
    }
    
    @PreDestroy
    public void preDestroy() {
    	cart=null;
    }
}



