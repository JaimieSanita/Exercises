package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

    	int[]   arrrr   = new int[10];
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        
        //read an input string from the command line....it better be shaped like a number or we have problems
        String percentageString = scanner.nextLine();
        
        // convert the input string into a double...unless it's not shaped like a number, then we crash
        double percentDiscount = Double.parseDouble(percentageString);
        
        // take the number and covert it into a fraction so we can take the discount
        double decimalDiscount = percentDiscount/100.0;
        
        System.out.println("The discount you entered as a decimal is " + decimalDiscount);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        
        // prompt the user for a series of numbers separated by a space...
        // again, we have to hope they give us good data
        String pricesAsString = scanner.nextLine();
        
        // split the large string into individual price strings
        // use string.split which takes a separator string
        String[] pricesAsIndividualStrings = pricesAsString.split(" ");
        
        // Need to parse each string into a double
        
        // create a double array to hold the prices
        double[] prices = new double[pricesAsIndividualStrings.length];
        
        
        // i ++ means i = i + 1;
        
        // loop through the price strings
        for(int i = 0; i < pricesAsIndividualStrings.length; i++) {
        	//get a string variable to parse
        	String stringToParse = pricesAsIndividualStrings[i];
        	//parse each string into a double
        	double price = Double.parseDouble(stringToParse);
        	//apply the discount to the double
        	price = price - (price * decimalDiscount);
        	//    store that double in the double array
        	prices[i] = price;
        
        }
        
        
        // loop through the discounted prices and print them
        System.out.println("You qualified for a discount. Discounted prices are:");
        for(int j = 0; j < prices.length; j++) {
        	double price = prices[j];
        	System.out.print("$" + price + "\t");
        }
        System.out.println();



    }

}