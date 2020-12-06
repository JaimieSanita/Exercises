package com.techelevator;
import java.util.Scanner;
public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println("Starting binary");
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String decimalValueString = userInput.nextLine();	
		String [] decimalsAsIndividualStrings = decimalValueString.split(" "); 
		 double[] binaryMath = new double[decimalsAsIndividualStrings.length]; //array called decimals holding individual decimals
		 
		 for(int i = 0; i < decimalsAsIndividualStrings.length; i++) {	//loop through individual decimals
			 String stringToParse = decimalsAsIndividualStrings[i]; //pull out decimal from array
			 double decimal = Double.parseDouble(stringToParse); // parse string to double
			 //apply conversion math
			 decimal = (decimal % 2); 
			 decimal = decimal / 2;
			 binaryMath[i] = decimal;
			 
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
