package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		
		         //Declaration statement
		//Data Type         // Variable Name
		int                 numberOfExercises;

		
		// THIS IS INVALID BECAUSE IT IS NOT INITIALIZED
		// int z = 5 * numberOfExercises;
		
		//        Assignment statement
		
		// variable        assigment operator         assignment value
		numberOfExercises           =                    26;
		
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		
		//declaration     assignment operator         value
        //datatype variable
		double     half        =                           0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "TechElevator";
		
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		
		int seasonsOfFirefly = 1;
		
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/

		String myFavoriteLanguage = "Java";
		
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		
		/**************************************************
		 * This is a flowerbox comment
		 * 
		 * 
		 * ************************************************/
		 
		double pi = 3.1416;

		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		
		
		String myName = "Andrew";
		
		// This line won't work because myName is already declared, change a variable with a pure assignment
		// String myName = "Foo";
		
		System.out.println(myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
			int numberOfButtons = 0;
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
			double percentageOfBattery = 100.0;
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
			
			
			
			                      // NOT A VALUE
        //        int             int op int
	    //        int      =       int
			int diffBetween =     121 - 27;
			System.out.println(diffBetween);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
			double addTwelveAndThirtyTwo = 12.3 + 32.1;
			System.out.println(addTwelveAndThirtyTwo);
		/*
		12. Create a String that holds your full name.
		*/
			String fullName = "Andrew Abraham McGuier";
			System.out.println(fullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
			//    String      =   String  op  String variable
			String helloAndrew = "Hello, " + fullName;
			System.out.println(helloAndrew);
			
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

			//variable assignment       expression
			fullName    =               fullName + " Esquire";
			System.out.println(fullName);
			System.out.println(helloAndrew);
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
			fullName += " Esquire";
			// exactly equivalent to 14
			System.out.println(fullName);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
			String saw = "Saw " + 2;
			System.out.println(saw);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
				saw += 0;
				System.out.println(saw);
		/*
		18. What is 4.4 divided by 2.2?
		*/
				double div = 4.4/2.2;
				System.out.println(div);
		/*
		19. What is 5.4 divided by 2?
		*/      
				// double     = double / int
				// double      = double / double
				double divdiv = 5.4 / (double)2;
				System.out.println(divdiv);
		/*
		20. What is 5 divided by 2?
		*/
				int divdivdiv = 5/2;
				System.out.println(divdivdiv);

		/*
		21. What is 5.0 divided by 2?
		*/
				// double        = double / int
				// double        = double / double
				double nonCasted = 5.0/2;
				
				//    double         double / int
				//    double          int / int
				//    double          int
				double casted = (int)5.0/2;
				System.out.println(nonCasted);
				System.out.println(casted);
				
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
				double weird = 66.6/100;
				System.out.println(weird);
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
				int rem = 5%2;
				System.out.println(rem);
		/*
		24. What is 1,000,000,000 * 3?
		*/
				// long          =   long  * int
				// play around with changing the various data types and inserting casts
				// see what happens to the answer
				long bigMultiply = (1000000000L * 3);
				System.out.println(bigMultiply);
				
				//int hugeInt = 5000000000;
				
				long five = 5L;
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
				boolean doneWithExercises = false;
				System.out.println(doneWithExercises);

		/*
		26. Now set doneWithExercise to true.
		*/
				doneWithExercises = true;
				System.out.println(doneWithExercises);
		
	}

}
