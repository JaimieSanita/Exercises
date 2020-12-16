package com.techelevator;

public class SquareWall extends RectangleWall {

	//INSTANCE VARIABLE
	
	private int sideLength;
	
	//GETTER
	
	public int getSideLength() {
		return sideLength;
	}
	
	//CONSTRUCTOR
	public SquareWall(String name, String color, int sideLength) {
		super(name, color, sideLength, sideLength);
		this.sideLength = sideLength;
	}
	
	
	
	public String toString() {
		return this.getName() + " (" + this.getSideLength() + "x" + this.getSideLength() + ") " + "square";
	}
	
	@Override
	public int getArea() {
		int sideArea = 0;
		sideArea = this.getSideLength() * this.getSideLength();
		return sideArea;
	}

}
	



