package com.shoppingcart.logic;

import java.util.Hashtable;

import javax.ejb.Remote;

@Remote
public interface CartRemote {
	void putItem(String itemId, int qty);
	void removeItem(String itemId);
	Hashtable<String, Integer> getItem();
}
