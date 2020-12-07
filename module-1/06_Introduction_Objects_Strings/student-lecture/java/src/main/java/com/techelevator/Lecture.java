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

		/* create an new instance of String using a literal */
		String tvShow = "Queen's Gambit";
		//note this actualy creates two strings " is great" and " Queen's Gambit is great"
		//references to "Queen's Gambit" and " is great" are gone for java to reference but memory in Heap saved
		tvShow += " is great";
		

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String scary = "Winter is coming!";
		
		String notScary = "Puppies are wonderful";
		
		
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
		 * 
		 * Strings are immutable practical example
		 * 
		 */
		System.out.println(scary);
		System.out.println(scary.toUpperCase());
		System.out.println(scary);
		
		/**
		 * 
		 * String boolean operations
		 * 
		 */
		if(notScary.contains("Puppies")) {
			System.out.println("Awww");
		}
		
		//case sensitive contains or startswith
		//can use two dot operators because notScary.toLowerCase is a string and therefore can have a contains() method attached
		if(notScary.toLowerCase().contains("puppies")) {
			System.out.println("double awwwww");
		}
		
		String shakesp = "Hamlet";
		
		if (shakesp.startsWith("Ham")) {
			System.out.println("What better to have for breakfast");
		}
		
		if (shakesp.endsWith("let")) {
			System.out.println("Tis better to suffer the slings and arrows ...");
		}
		
		if (shakesp.equalsIgnoreCase("hamlet")) {	//could also to .toLowerCase().equals("placeholder")
				System.out.println("Yep, it's a hammy play");
				}
		
		/**
		 * 
		 * String length is a method, not a value
		 * 
		 */
		
		double [] doubles = new double[5];
		int doublesLength = doubles.length; //notice there are no (); can not change length of array; length is property of array
		
		String favorites = "Mashed Potatoes";
		int stringLength = favorites.length(); //must of (); because method call
		System.out.println(stringLength);
		
		String funny = "Thirty Rock";
		String rock = funny.substring(7); //substring() takes snip of String at index identified in (); 
		System.out.println(rock);			//because only one index provided, return untl end of string
	
		String review = funny + " is not great";
		System.out.println("Original review: " + review);
		//Thirty Rock is not great
		String editedReview = review.substring(0, 15) + review.substring(19); //return Thirty Rock is great
		System.out.println(editedReview);
		
		String sentences = "The quick brown fox jumped. The small cat played.";
		int indexOfPeriod = sentences.indexOf("."); //will return integer index of first period in String sentence
		System.out.println(indexOfPeriod);
		String theFirstSentence = sentences.substring(0,indexOfPeriod + 1); //to include the period add (+1) 
		System.out.println(theFirstSentence);
		
		int indexOfSecondPeriod = sentences.indexOf(".", indexOfPeriod+1); 
		System.out.println("The index of the second period is: " + indexOfSecondPeriod);
		
		System.out.println("Next period index" + sentences.indexOf(".", indexOfSecondPeriod+1)); // returns -1 because no other periods to find
		
		/**
		 * 
		 * Example of loops with indexOf
		 */
		int periodCount=0;	
		//starting at index 26				//loop as long as index > 0;	//next iteration of loop is next found period index
		for (int index = sentences.indexOf("."); index > 0;  					index = sentences.indexOf(".", index+1)) {
			System.out.println("Period found at index: " + index);
			periodCount++;	//add 1 to periodCount
		}
		System.out.println("We found " + periodCount + " periods.");
		
		/**
		 * 
		 * String replace
		 * 
		 */
		
		String dozer = "Dozer is bad dog!";
		dozer = dozer.replace("bad", "good");
		System.out.println(dozer);
		
		/**
		 * 
		 * Bonus content
		 * 
		 */
		
		String lotsASpace= "            Hello              ";
		System.out.println("This string: " + lotsASpace.strip() + " :complete"); //removes spaces
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();


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
		String hello4 = "H" + "ello";
		if (hello1 == hello4) {
			System.out.println("hello1 is the same reference as hello4");
		}else {
				System.out.println("hello1 is not the same reference as hello4");
			}
		}
	}

