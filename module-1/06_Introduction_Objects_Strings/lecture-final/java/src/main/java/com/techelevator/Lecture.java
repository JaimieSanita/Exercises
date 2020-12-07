package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */
		
		// Strings and Arrays are the only reference types in java that get special syntax
		// Strings use "" for a literal
		// arrays use [] for indexing and { } for static initialization

		/* create an new instance of String using a literal */
		
		String tvShow = "Queen's Gambit";
		
		// note this actually creates two new strings " is great" and "Queen's Gambit is great"
		tvShow += " is great";

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String scary = "Winter is coming!";
		
		String notScary = "Puppies are wonderful.";

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		/**
		 * Strings are immutable
		 * practical example
		 */
		
		System.out.println(scary);
		System.out.println(scary.toUpperCase());
		System.out.println(scary);

		/**
		 * String boolean operations
		 * 
		 */
		if(notScary.contains("Puppies")) {
			System.out.println("Awwwwwww");
		}
		
		// case insensitive contains or startswith
		// see equals below case below for a similar example
		if(notScary.toLowerCase().contains("puppies")) {
			System.out.println("double awwwwwwwww");
		}
		
		String shakesp = "Hamlet";
		
		if(shakesp.startsWith("Ham")) {
			System.out.println("What better to have for breakfast");
		} // ends this if/else chain
		
		if(shakesp.endsWith("let")) {
			System.out.println("Tis better to suffer the slings and arrows....");
		}
		
		if(shakesp.equalsIgnoreCase("hamlet")) { // could also do .toLowerCase().equals("anystring");
			System.out.println("Yep, it's a hammy play");
		}
		
		/**
		 * String length is a method not a value
		 */
		
		double[] doubles = new double[5];
		int doublesLength = doubles.length; //Notice there are no () here
		
		String favorites = "Mashed Potatoes";
		int stringLength = favorites.length(); // () are obligatory
		
		String funny = "Thirty Rock";
		System.out.println(funny);
		
		String rock = funny.substring(7); // takes a cut of the string from the provided index to the end of the string
		System.out.println(rock);
		
		String review = funny + " is not great!";
		System.out.println("Original review: " + review);
		
		//Thirty Rock is not great!
		
		//substring(start,end) includes first index, excludes the second index
		String editedReview = review.substring(0, 15) + review.substring(19);
		System.out.println(editedReview);
		
		// see below for string replace
		String edited2 = review.replace("not", "");
		System.out.println(edited2);
		
		String sentences = "The quick brown fox jumped. The small cat played.";
		
		// manually use indexOf and substring
		int indexOfPeriod = sentences.indexOf("."); // the positive index of the first instance of "." or -1 if it can't find it
		String theFirstSentence = sentences.substring(0,indexOfPeriod+1);
		System.out.println(theFirstSentence);
		
		int indexOfSecondPeriod = sentences.indexOf(".", indexOfPeriod+1);
		System.out.println("Index of the second period is: " + indexOfSecondPeriod);
		
		System.out.println("Next period index " + sentences.indexOf(".",indexOfSecondPeriod+1));
		
		/**
		 * Example of loops with indexOf
		 */
		int periodCount = 0;
		
		for(int index = sentences.indexOf("."); index > 0; index = sentences.indexOf(".",index+1)) {
			System.out.println("Period found at index: " + index);
			periodCount++;
		}
		
		System.out.println("We found "+ periodCount + " periods.");
		
		
		/***
		 * String replace
		 */
		
		String dozer = "Dozer is a bad dog!";
		dozer = dozer.replace("bad", "good");
		System.out.println(dozer);
		
		/**** 
		 * 
		 * Bonus content, not really needed for your homework
		 * 
		 */
		
		String lotsASpace = "      Hello      ";
		System.out.println("This string: " + lotsASpace.strip() + " :complete");
		
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		//TAKEAWAY DO NOT USE == ON STRINGS
		// You ABSOLUTELY will get BUGS
		
		String hello1 = "Hello";
		String hello2 = "Hello";
				

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello4 = "H";
		hello4 += "ello";
		
		if(hello1 == hello4) {
			System.out.println("hello1 is the same reference as hello4");
		}else {
			System.out.println("hello1 is not the same reference as hello4");
		}
		
		if(hello1.equals(hello4)) {
			System.out.println("The content of hello1 and hello4 is the same");
		}else {
			System.out.println("The content of hello1 and hello4 is different");
		}
		
	}
}
