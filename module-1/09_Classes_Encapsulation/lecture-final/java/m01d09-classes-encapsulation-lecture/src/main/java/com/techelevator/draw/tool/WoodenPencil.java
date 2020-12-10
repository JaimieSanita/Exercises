/*
 * PACKAGE DEFINITION
 * 
 * lowercase
 * multi-words separated by periods
 * generally align it with the purpose of your project
 * 
 * There's an art to how many packages you have vs how many classes per package
 */
package com.techelevator.draw.tool;

/*
 * IMPORT
 * 
 * import a TYPE from a PACKAGE
 * 
 * this is optional, if you need a type, you import it
 */

import java.awt.Color;

/*
 * 
 * CLASS DECLARATION
 * 
 * 
 * PascalCase and they are traditionally singular
 */
//access       class keyword       class name    { 
public class WoodenPencil {

	/*
	 * CLASS VARIABLES (FIELDS)
	 * 
	 */

	// CONSTANTS
	// access part of the class not the instance variable can't change regular
	// variable declaration
	public static final double defaultLength = 8.0;

	public static final int defaultShape = 2;
	public static final String defaultHardness = "HB";
	public static final Color defaultColor = Color.YELLOW;
	public static final double defaultStubLength = 2.0;
	public static final double defaultMaxDullness = 0.3;

	/****
	 * 
	 * INSTANCE VARIABLES
	 */

	private double length; // in inches
	private int shape; // 1 is triangular, 2 - hexagonal, 3 - round
	private String hardness; // "B" "HB" "F" "H" "2H"
	private Color color; // color of the exterior
	private double sharpness; // min 0.0, max 1.0
	private boolean favorite;

	/**
	 * GETTER / SETTER
	 */

	public double getLength() {
		return length;
	}

	public int getShape() {
		// audit and and count that this was called
		return shape;
	}

	public String getHardness() {
		return hardness;
	}

	public Color getColor() {
		return color;
	}

	public double getSharpness() {
		return sharpness;
	}

	/*
	 * DERIVED GETTER
	 * 
	 * a getter which is calculated on the fly from other values in the class
	 */
	public boolean isSharp() {
		if (this.sharpness > defaultMaxDullness) {
			return true;
		} else {
			return false;
		}
	}

	// boolean type things we replace the GET with IS
	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean newFavorite) {
		favorite = newFavorite;
	}

	/*
	 * 
	 * CONSTRUCTOR
	 * 
	 */

	// Empty constructor
	public WoodenPencil() {
		this(defaultLength, defaultShape, defaultHardness, defaultColor, 0.0);
	}
	
	// constructor with all arguments
	public WoodenPencil(double length, int shape, String hardness, Color color, double sharpness) {
		// Set the color
		if (color != null) {
			this.color = color;
		} else {
			this.color = defaultColor;
		}

		// set the shape
		if (shape == 1 || shape == 2 || shape == 3) {
			this.shape = shape;
		} else {
			this.shape = defaultShape;
		}

		if (length > 0 && length <= defaultLength) {
			this.length = length;
		} else {
			this.length = defaultLength;
		}

		// you can use a ternary instead of if/else for this kind of conditional
		this.sharpness = sharpness >= 0.0 && sharpness <= 1 ? sharpness : 0.0;

		if (hardness.equals("B") || hardness.equals("F") || hardness.equals("H") || hardness.equals("2")) {
			this.hardness = hardness;
		} else {
			this.hardness = defaultHardness;
		}
	}

	/*
	 * 
	 * METHODS
	 * 
	 */
	
	public boolean sharpen() {
		double newLength = this.length - 0.25;
		if(newLength >= defaultStubLength && newLength >= 0.0) {
			this.sharpness = 1.0;
			this.length = newLength;
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Tech Elevator custom pencil store");
		
		// Call the full constructor with arguments
		WoodenPencil forTheSat = new WoodenPencil(6, 3, "H", Color.BLUE, 1.0);
		
		
		
		// construct a default pencil
		WoodenPencil numberTwo = new WoodenPencil();
		
		if(numberTwo.sharpen()) {
			System.out.println("The number two pencil is " + numberTwo.getLength() + " inches long");
		}else {
			System.out.println("I couldn't sharpen it");
		}
		
		System.out.println("Number Two: " + numberTwo.getLength() + "   Sat: " + forTheSat.getLength());
		
	}
	
}
