package com.techelevator;
import java.util.Scanner;
public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println("Starting binary");
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String decimalValueString = userInput.nextLine();	
		String [] decimalsAsIndividualStrings = decimalValueString.split(" "); 
		 double[] decimalArray = new double[decimalsAsIndividualStrings.length]; //array called decimals holding individual decimals
		 
		 for(int i = 0; i < decimalArray.length; i++) {	//loop through individual decimals
			 String stringToParse = decimalsAsIndividualStrings[i]; //pull out decimal from array
			 int decimal = Integer.parseInt(stringToParse); // parse string to integer
			 int [] binaryArray = new int [20];
			 for (int j = 0; j < binaryArray.length; j++) {
				 j = j / 2;
				 binaryArray[i] = j % 2;
			 System.out.print(stringToParse + " in binary is " + j + "\n");
		 }
	}
	}
}
//Write a command line program which prompts the user for a series of decimal integer values separated by spaces. 
//Each decimal integer is displayed along with its equivalent binary value.
//Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

//460 in binary is 111001100
//8218 in binary is 10000000011010
//1 in binary is 1
//31313 in binary is 111101001010001
//987654321 in binary is 111010110111100110100010110001
