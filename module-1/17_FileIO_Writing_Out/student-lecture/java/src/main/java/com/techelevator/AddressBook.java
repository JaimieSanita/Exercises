package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddressBook {

	private final static String ADDRESS_PATH = "AddressBook"; // creation of a constant

	// pass in inputScanner
	public static File createAddressFolderIfNeeded() {
		File addressBook = new File(ADDRESS_PATH);
		// must check if this exists
		if (addressBook.exists()) {

			// if yes, make sure the file object is a directory(folder), not a file
			if (addressBook.isDirectory()) {
				return addressBook;
			} else {
				System.out.println("AddressBook already exists and is not a folder!");
				System.exit(1);
				return null;
			
			// if no, make new directory
		}}else {
			if (addressBook.mkdir()) {
				return addressBook;
			} else {
				System.out.println("Unable to make address book.");
				System.exit(1);
				return null;
			}
		}
	}

	public static void main(String[] args) {
		


		Scanner inputScanner = new Scanner(System.in);
		

		// Make sure I have a local AddressBook directory created
		// create it if it doesn't exist
		
		File addressBook = createAddressFolderIfNeeded();


		// prompt user for a name
		
		System.out.println("Enter the name of your contact >>>");
		
		String name = inputScanner.nextLine();
		
		
		//manipulating a string to replace black spaces with underscore
		String fileName = name.replace(" ", "_") + ".txt";
		
		//full file name will be the addressbook/filename.txt
		File addressFile = new File(addressBook.getAbsoluteFile(), fileName );

		// check if we have an address for the user already
		// if so, allow them to y/n update the address
		
		if(addressFile.exists()) {
			System.out.println("It already exists!");
			System.out.print("Update existing recond? Y/N >>>");
			String update = inputScanner.nextLine();
			
			//if we're not updating exit successfully
			if(!update.toLowerCase().equals("y")) {
				System.out.println("NOt updating the current address. Exiting.");
				System.exit(0); //exit 0 because this is a successful reason to quit early
			}
		}

		// prompt them for address line 1
		System.out.print("Address line 1 >>> ");
		String add1 = inputScanner.nextLine();
		
		// prompt them for address line 2
		System.out.print("Address line 2 >>> ");
		String add2 = inputScanner.nextLine();
		
		// prompt them for city
		System.out.print("City >>> ");
		String city = inputScanner.nextLine();
		
		// prompt them for state
		System.out.print("State >>> ");
		String state = inputScanner.nextLine();
		
		// prompt them for zip
		System.out.print("Zip >>> ");
		String zip = inputScanner.nextLine();
		

		// open a file and write out the address content
		try(PrintWriter writer = new PrintWriter(addressFile)) {
			//Name header
			writer.println("Name: ");
			writer.println();
			
			//Name indented
			writer.println("\t" + name);
			
			//Space between entries
			writer.println();
			writer.println();
			
			//Address Header
			writer.println("Address: ");
			writer.println();
			
			//first address line
			writer.println("\t" + add1);
			
			//not all addresses have 2 lines
			if(!add2.equals("")) {
				writer.println("\t" + add2);
			}
			
			//city state and zip go on one line so note the use of print rather than println 
			writer.print("\t" + city);
			writer.print("," + state);
			writer.print(" " + zip);
		}catch (FileNotFoundException fne) {
			System.out.println("Unable to write to the address file.");
			System.exit(1);
		}
		}

	}


