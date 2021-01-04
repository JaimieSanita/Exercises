package com.techelevator.scanner;

// File class in java which represents a file in the operating system's file tree
import java.io.File;

// An error that occurs when our code accesses a file that does not exist
import java.io.FileNotFoundException;

// return of the scanner!
// Scanner is a utility class for representing a stream of characters
// it doesn't care if that stream of characters is from a file, or from the command line
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		
		
		
		
		// TRY RESOURCE BLOCK
		// special form of the try/catch block
		// when we have things that implement the Closeable interface
		// we can declare them in a set of ()
		// after the try
		// and java will automatically add a finally {} block
		// that closes the underlying resource
		try(Scanner fileScanner = new Scanner(inputFile)) {
		
			// scanners behave the same on files or on text streams
			while(fileScanner.hasNextLine()) {
				
				// notice nextLine works just like when we used the command line 
				String line = fileScanner.nextLine();
				
				// take the first 9 characters
				String rtn = line.substring(0, 9);
				
				// if the valid method doesn't come back correct
				if(!checksumIsValid(rtn)) {
					System.out.println(line);
				}
			}
			
			
			
		} 
		
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		
		// WARNING WARNING WARNING
		// DO NOT use a TRY RESOURCE block with a scanner for System.in
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		
		
		
		if(!inputFile.exists()) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(!inputFile.isFile()) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
