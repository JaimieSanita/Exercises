package com.techelevator.store;

import java.util.List;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

public abstract class Store {
	
	private Map<String, StoreItem> inventory = new HashMap<String, StoreItem>();

	//we want to include a list of items
	//crate a store item class and take a list in checkout()
	//created separate class called StoreItem to make a List here named cart
	//BigDecimal is immutable
	public  BigDecimal checkout(List<StoreItem> cart) {
		//setting total equal to 0 but need to use .method
		BigDecimal total = BigDecimal.ZERO;
		//if receiving reference type, check for null first
		if(cart == null) {
			return total;
		}
		//for each StoreItem variable called item in the cart list...
		for(StoreItem item : cart) {
			//get the item total and add to total variable created called total
			//using .methods because using BigDecimal no use of ( + - * /) because not built into java language
			total = total.add(item.getTotal());
		}
		
		return total;
	}
	
	//method to give back change; that's why tendered included
	public final BigDecimal pay(List<StoreItem> cart, BigDecimal tendered) {
		//get total by creating BigDecimal variable called cartTotal
		//equal to checkout(cart) because that method return the total of balance of each item in cart
		BigDecimal cartTotal = checkout(cart);
		//need to check that tendered amount from shopper is greater than or equal to cartTotal
		//if tendered less than total, cant happen
		//use .compareTo because can't use <=>= on BigDecimal; returns -1 if false, 0 is equal, 1 if true
		if(tendered.compareTo(cartTotal) >=0) {
			return tendered.subtract(cartTotal);
		} else {
			return null;
		}
	}
	
	
	
	//take a list of items and print out receipt
	public abstract void printReceipt(List<StoreItem> cart);
	
	//if public anyone can stock items; if private no one can stock items
	//use protected b/c want implementing store to be able to stok items but don't want public to be able to stock items
	protected final boolean stockItem(StoreItem item) {
		//check there is storeItem and item price at least 0
		if(item != null && item.getQuantity() > 0 && item.getPrice().compareTo(BigDecimal.ZERO) >= 0) {
			//if conditions true; add to inventory map
			inventory.put(item.getName(), item);
			//because restocked successfully
			return true;
		} else {
			return false;
		}
	}
	
	//method to select an item by item name
	public StoreItem selectItem(String itemName) {
		//check if item is in Map
		if(inventory.containsKey(itemName)) {
			//get item
			StoreItem item = inventory.get(itemName);
			if(item.getQuantity() > 0) {
				//change
				StoreItem forCustomer = new StoreItem(item.getName(), item.getPrice(), 1);
				//decreased store stock by 1
				StoreItem updatedStock = new StoreItem(item.getName(), item.getPrice(), -1);
				//add updated Stock to inventory map because gave item to customer
				inventory.put(itemName, updatedStock);
			}
		} 
		
		return null;
	}
	
	//is item on sale depending on item name
	public abstract boolean isOnSale(String itemName);
	
	//percent item is discounted depending on item name
	public abstract BigDecimal percentageDiscount(String itemName);
	
	
}
