package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {			//method called main
    		int[] arrr = new int[10];
        Scanner scanner = new Scanner(System.in);		//data type is Scanner; variable name "scanner"; Scanner is reference type; new means creating new memory;
        												//(System.in) is argument; system.in represents user input (outside world);
        System.out.println("Welcome to the Discount Calculator"); //print an automatic line

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): "); //because System.out.print WITHOUT ln this and below item print on same line
        String percentageString = scanner.nextLine();					
        double percentDiscount= Double.parseDouble(percentageString); //need to turn String into double and will convert String into double; if used int instead of double, would get error;
        double decimalDiscount= percentDiscount / 100.0; //takes from whole number percent to decimal percent discount
        System.out.println("The discount you entered as a decimal is " +  decimalDiscount); //incantation

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): "); // printed on same line as above because no printLN
        
        //Prompt the user for a series of numbers separated by a space...& hope they give us good data
        String pricesAsString = scanner.nextLine(); 
        //split the large string into individual price strings
        //use string.split which takes a separator string and creates new array under the hood
        String [] pricesAsIndividualStrings= pricesAsString.split(" "); //want to seperate string into multiple strings
        //need to parse each string into a double but don't know number of prices
        
        //create a double array to hold the prices
        double[] prices = new double[pricesAsIndividualStrings.length];
        
        //loop through the price strings
        for (int i = 0; i < pricesAsIndividualStrings.length; i++) {
        	//get a string variable to parse
        	String stringToParse = pricesAsIndividualStrings[i]; //get price out of array as string
        	
        	//parse each string into a double
        	double price = Double.parseDouble(stringToParse);
        	
        	//apply discount to double
        	
        	price = price - (price*decimalDiscount); //math to get discount
        	
        	//store that double in the double array
        	
        	prices[i] = price; // 
        	
        	
        }
        //loop through discounted prices
        System.out.println("You qualified for a discount. Discounted prices are:");
        for (int i=0; i < prices.length; i++) {
        	double price = prices[i];
        	System.out.print("$" + price + "\t");
        //print each discounted price
        
        }
        System.out.println(); //empty line
       
        

        



    }

}