package com.techelevator;
import java.util.Scanner;

public class stringsAreWeird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello1 = "Hello";
		String hello2 = "Hello";
		System.out.print("Type Hello: ");
		Scanner scanner = new Scanner(System.in);
		String hello3 = scanner.nextLine();
		
		// THIS IS BAD DO NOT DO NOT DO NOT
		boolean oneAndTwo = hello1 == hello2; // NO
		boolean twoAndThree = hello2 == hello3; // NO
		
		// Only use the equality operator for primative types.
		// Do not use it for strings, instead use .equals for all reference types
		
		System.out.println("OneAndTwo: " + oneAndTwo);
		System.out.println("TwoAndThree: " + twoAndThree);
				
		System.out.println("This is better");
		boolean oneAndTwoCorrect = hello1.equals(hello2);
		boolean twoAndThreeCorrect = hello2.equals(hello3);
		System.out.println("Correct 1: " + oneAndTwoCorrect);
		System.out.println("Correct 2: " + twoAndThreeCorrect);
				

	}

}
