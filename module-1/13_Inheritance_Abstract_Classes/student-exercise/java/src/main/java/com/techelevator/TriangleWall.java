package com.techelevator;

public class TriangleWall extends Wall {
	
	//INSTANCE VARIABLES
	private final int base;
	private final int height;
	
	//GETTERS
	
	public int getBase() {
		return base;
	}
	
	public int getHeight() {
		return height;
	}
	
	

	public TriangleWall(String name, String color,  int base, int height) {
		super(name, color);
		this.base = base;
		this.height = height;
	}



	@Override
	public int getArea() {
		int triArea = 0;
		triArea = (this.getBase() * this.getHeight()) /2;
		return triArea;
	}
	
	public String toString() {
		return this.getName() + " (" + this.getBase() + "x" + this.getHeight() + ") " + "triangle";
	}

}
