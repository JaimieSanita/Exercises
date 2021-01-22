package com.techelevator.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Sandwich {
	
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal unitPrice;
	private boolean available;
	private List<Category> categories;
	
	public Sandwich(List<Category> categories) {
		// just make sure we don't have a null list
		this.categories = categories == null ? new ArrayList<Category>() : categories;
	}
	
	// read only getter for categories
	// we use the array type because it makes it clear that you cannot 
	// update the categories directly from the sandwich object
	public Category[] getCategories() {
		Category[] catArray = new Category[this.categories.size()];
		return this.categories.toArray(catArray);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
