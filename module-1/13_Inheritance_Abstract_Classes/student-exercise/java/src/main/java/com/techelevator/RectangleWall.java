package com.techelevator;

public class RectangleWall extends Wall {

	//INSTANCE VARIABLES
	private int length;
	private int height;
	
	//GETTERS
	
	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	//CONSTRUCTOR
	public RectangleWall(String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	}

	@Override
	public int getArea() {
		int totalArea = 0;
		totalArea = this.getLength() * this.getHeight();
		return totalArea;
	}
	
	public String toString() {
		return this.getName() + " (" + this.getLength() + "x" + this.getHeight() + ") " + "rectangle";
	}

}
