package com.techelevator.store;

import java.math.BigDecimal;

public class StoreItem {
	
	private String name;
	private BigDecimal price;
	private int quantity;
	
	//don't want user to edit private variables; so only make getters
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	//constructor
	
	StoreItem (String name, BigDecimal price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	//derived getter; this getter is called in Override below
	public BigDecimal getTotal() {
		if(quantity > 0) {
			return this.getPrice().multiply(new BigDecimal(this.getQuantity()));
		} else {
			return BigDecimal.ZERO; //if no items
		}
		
	}
	
	//create override of base object toString() which provides representation of base object or textually represents object
	//there toString() needs to be informative and concise representation
	@Override
	public String toString() {
		//created by multiplying price times quantity; can't use operators on BigDecimal, need .methods
		
		return "Item: " + this.getName() + "price: $" + this.getPrice() + " quantity: " + this.getQuantity() + this.getTotal();
	}

}
