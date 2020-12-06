package com.techelevator;
import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Starting fibbonacci");
		//allows for user input
		Scanner userInput = new Scanner(System.in);
		//displays prompt
		System.out.print("Please enter the Fibonacci number: ");
		//converts user input into string
		String userString = userInput.nextLine();
		//converts string into double, a number
		int userFibNum = Integer.parseInt(userString); // consider sub integer.parseInt
		
		int finalFibNumInSequence = userFibNum;
		int firstNumIsZero = 0;
		int secondNumIsOne = 1;
		System.out.print(firstNumIsZero);
		//set for loop to one because sequence starts at 0,1; and i is less than or equal to startNum - 2 because already set 0 and 1 of sequence;
		//++i increments first, then uses
		//i++ uses first, then increments
		for (int i=1; i <= finalFibNumInSequence; ++i) {
	                int sum = firstNumIsZero + secondNumIsOne; //sum is 0+1
	                firstNumIsZero = secondNumIsOne; //0=1
	                secondNumIsOne = sum; //
	                if (secondNumIsOne != userFibNum) {
	                System.out.print(", " + sum);
	                } else {
	                	break;
	                }
		}
	}
}

//The Fibonacci numbers are the integers in the following sequence:
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...

//By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.

//Write a command line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.
//Please enter the Fibonacci number: 25

//0, 1, 1, 2, 3, 5, 8, 13, 21
