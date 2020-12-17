package com.techelevator.store;

import java.util.List;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

public abstract class Store {

	private Map<String,StoreItem> inventory = new HashMap<String,StoreItem>();
	
	// we want to include a list of items
	// create a store item class and take a list in here
	public final BigDecimal checkout(List<StoreItem> cart) {
		BigDecimal total = BigDecimal.ZERO;
		if(cart == null) {
			return total;
		}
		
		for(StoreItem item : cart) {
			total = total.add(item.getTotal());
		}
		
		return total;
	}

	public final BigDecimal pay(List<StoreItem> cart, BigDecimal tendered) {
		BigDecimal cartTotal = checkout(cart);
		if(tendered.compareTo(cartTotal) >= 0) {
			return tendered.subtract(cartTotal);
		} else {
			return null;
		}
	}
	
	// take a list of items and print out the receipt
	public abstract void printReceipt(List<StoreItem> cart);
	
	// we use protected because we want implementing stores
	// to be able to stock items, but we don't want the public to be able
	// to stock items
	protected final boolean stockItem(StoreItem item) {
		if(item != null && item.getQuantity() > 0 && item.getPrice().compareTo(BigDecimal.ZERO) >= 0) {
			inventory.put(item.getName(), item);
			return true;
		}
		else {
			return false;
		}
	}
	
	public StoreItem selectItem(String itemName) {
		if(inventory.containsKey(itemName)) {
			StoreItem item = inventory.get(itemName);
			if(item.getQuantity() > 0) {
				StoreItem forCustomer = new StoreItem(item.getName(), item.getPrice(),1);
				StoreItem updatedStock = new StoreItem(item.getName(), item.getPrice(), item.getQuantity() - 1);
				inventory.put(itemName,updatedStock);
				return forCustomer;
				
			}
		}
		
		
		return null;
	}
	
	public abstract boolean isOnSale(String itemName);
	
	public abstract BigDecimal percentageDiscount(String itemName);
	
	
	
}
