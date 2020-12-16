package com.techelevator;

public abstract class Wall {
	//PARENT CLASS
	//All fields must be readonly fields. This means each field has a getter, but not a setter.
	//INSTANCE VARIABLES
	 private final String name;
	 private final String color;
	
	//GETTERS
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	//CONSTRUCTOR
	public Wall(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public abstract int getArea(); 
	

	
}
