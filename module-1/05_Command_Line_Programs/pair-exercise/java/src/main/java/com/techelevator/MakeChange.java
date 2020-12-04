package com.techelevator;
import java.util.Scanner;
/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		//input scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the amount of the bill: ");
		//need string to store
		String billAmountEntered= scanner.nextLine();
		//need to convert string into double
		double billAmount = Double.parseDouble(billAmountEntered);
		
		System.out.print("Please enter the amount tendered: ");
		String tenderAmountEntered= scanner.nextLine();
		double tenderAmount = Double.parseDouble(tenderAmountEntered);
		
		double changeDue = tenderAmount - billAmount;
		System.out.print("The change required is: " + changeDue);
	}

}
