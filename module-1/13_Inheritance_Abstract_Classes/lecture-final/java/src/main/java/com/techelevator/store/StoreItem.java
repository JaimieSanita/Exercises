package com.techelevator.store;

import java.math.BigDecimal;

public class StoreItem {

	private String name;
	private BigDecimal price;
	private int quantity;
	
	StoreItem(String name, BigDecimal price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public BigDecimal getTotal() {
		if(quantity > 0) {
		  return this.getPrice().multiply(new BigDecimal(this.getQuantity()));
		} else {
			return BigDecimal.ZERO;
		}
	}
	
	@Override
	public String toString() {
		return "Item: " + this.getName() + " price: $" + this.getPrice() + " quantity: " + getQuantity() + " total: $" + this.getTotal() ;
	}
	
	

}
