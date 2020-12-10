
/**
 * 
 * PACKAGE DEFINITION
 * 
 * lowercase
 * multiwords separated by periods
 * generally align with purpose of project
 * 
 * There's an art to how many packages you have vs how many classes per package
 */

package com.techelevator.draw.tool;

/*
 * 
 * IMPORT
 * 
 * import a TYPE from a PACKAGE
 * 
 * this is optional, if you need a type, you import it
 * 
 * number of imports depends on what doing with class
 * 
 */

import java.awt.Color; //built-in java import

/*
 * 
 * CLASS DECLARATION
 * 
 *PascalCase
 *traditionally singular; best practice do not make plural
 *
 * 
 */
//access modifier			class keyword			class name		{begins body
public class WoodenPencil {

	/*
	 * 
	 * CLASS VARIABLES (FIELDS)
	 * 
	 * 
	 * 
	 */

	// CONSTANTS(need static && final) this variable/ method doesn't change from
	// object to object ie. static
	// available to see because public part of the class, not the instance variable
	// can NOT change regular variable declaration
	public static final double defaultLength = 8.0;
	// global values to class because "static" and cannot change because "final"
	public static final int defaultShape = 2;
	public static final String defaultHardness = "HB";
	public static final Color defaultColor = Color.YELLOW;
	public static final double defaultStubLength = 2.0;
	public static final double defaultMaxDullness = 0.3;

	/**
	 * 
	 * INSTANCE VARIABLES
	 * 
	 * 
	 */
	// Regular variable declaration with access modifier at beginning
	// private so can only use inside Class
	private double length; // in inches
	private int shape; // 1 is triangular; 2 is hexagonal; 3 is round
	private String hardness; // "B" "HB" "F" "H" "2H"
	private Color color; // color of the exterior; Color is a reference type from libraries free with
							// java
	private double sharpness; // min 0.0; max 1.0
	private boolean favorite;

	/**
	 * 
	 * GETTER / SETTER getters: type of private equals return type -give empty set
	 * of () to indicate a method -name is "get"Privatevariablename -can be used to
	 * audit/track use of user use to protect code and control how user can access
	 * variable
	 */

	public double getLength() { // public double method that returns a length variable; this is accessible to
								// outside world because public
		return length; // returns private piece of data
	}

	public int getShape() {
		// audit and count this was called
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
	 * 
	 * DERIVED GETTER
	 * 
	 * a getter calculated on the fly from other values in the class
	 */
	public boolean isSharp() { // no boolean value called sharp but b/c method can derive value from another
								// variable already have
		if (this.sharpness > defaultMaxDullness) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFavorite() { // boolean getters use "is" instead of "get"
		return favorite;
	}

	// always have to return same data type as get
	// setters are void methods
	// don't get value back, just do actionsz
	public void setFavorite(boolean newFavorite) { // when call setFavorite will change value from favorite to
													// newfavorite
		favorite = newFavorite; // could insert conditional logic instead of setting new value
	}

	/*
	 * 
	 * CONSTRUCTOR must exactly match the class file name method used to build the
	 * class can take parameters and use to initialize my pencil this. keyword to
	 * reduce ambiguity
	 */
	// because Color is reference type, null could be passed through so do if
	// statement ensure a color is used
	
	//declare 2nd constructor which is EMPTY; remember arguments must be unique so cannot match arguments of other constructor
	//when call constructor with empty and call constructor that takes all of parameters and sub in default values defined within this()
	//default pencil
	public WoodenPencil() {
		this(defaultLength, defaultShape, defaultHardness, defaultColor, 0.0);
	}
	//constructor with all arguments
	//design own pencil constructor
	public WoodenPencil(double length, int shape, String hardness, Color color, double sharpness) {
		// set the color
		if (color != null) {
			this.color = color; // set color on my Object equal to color given to me when i initialize; private
								// color value
		} else {
			this.color = defaultColor;
		}
		// set the shape
		if (shape == 1 || shape == 2 || shape == 3) {
			this.shape = shape;
		} else {
			this.shape = defaultShape;
		}

		// set the length
		if (length > 0 && length <= defaultLength) {
			this.length = length;
		} else {
			this.length = defaultLength;
		}

		// set sharpness with ternary operator
						// conditional test________________ ternary operator if true 	if false
		this.sharpness = sharpness >= 0.0 && sharpness <= 1 ? 				sharpness : 0.0;

		// set hardness
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
	//static means only one copy of method and attached to template, not individual method
	//void means doesn't return anything
	//method name is main
	//argument to method is String array called args
	//this is a constructor
	
	//instance method
	public boolean sharpen() {
		double newLength = this.length - 0.25;
		if(newLength >= defaultStubLength && newLength >= 0) {
			this.sharpness = 1.0;
			this.length = newLength;
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to the Tech Elevator custom pencil store.");
		//call full constructor with arguments
		WoodenPencil forTheSat = new WoodenPencil(6, 3, "H", Color.BLUE, 1.0); //new keyword tells java to get chunk of memory big enough
																				//to hold WoodPencil with specified arguments
		
		//construct a default pencil
		WoodenPencil numberTwo = new WoodenPencil();
		
		if(numberTwo.sharpen()) {
			System.out.println("The number two pencil is " + numberTwo.getLength() + "  inches long");
		} else {
			System.out.println("I couldn't sharpen it.");
		}
		
		System.out.println("Number Two: " + numberTwo.getLength() + "   Sat:  " + forTheSat.getLength());
	}
}
