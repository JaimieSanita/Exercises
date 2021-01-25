package com.techelevator.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Sandwich { //container
	
	//INSTANCE VARIABLES from Menu table in DBviz
	
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal unitPrice;
	private boolean available;
	private List<Category> categories;
	
	public Sandwich (List<Category> categories) {
		//ensure we don't have a null list
		//if categories has null variable make empty list
		//if not null, take what given and put in 
		this.categories = categories == null ? new ArrayList<Category>() : categories;
	}
	
	//GETTERS & SETTERS
	//READ ONLY GETTER FOR CATEGORY;use array type b/c makes clear that you cannot 
	//update the categories directly from the sandwich object b/c can't add/remove elements from array
	public Category[] getCategories() {
		Category[] catArray = new Category[this.categories.size()];
		return categories.toArray(catArray); //toArray turns list into array with elements in proper sequence
											//categories was list and is return as array
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
	

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
