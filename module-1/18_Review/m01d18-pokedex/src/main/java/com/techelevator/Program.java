package com.techelevator;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.pokemon.Pokemon;

public class Program {
	// HELPER METHODS	
		//consider helper methods as definitions & main method will call & implement
		//should be grouped with what you're doing // related
		// if a class is getting to 500lines, consider separating
											// resource to work with/parameter
	private static File promptForPokeDexFile(Scanner inputScanner) {
		File pokeDexFile = null; // set to null

		while (pokeDexFile == null) { // if condition true, go into body; if not true, go to return

			System.out.print("Enter the csv file for your pokedex: >>>"); // file needs to be validated
			String dexPath = inputScanner.nextLine();

			if (!dexPath.endsWith("csv")) {
				System.out.println("You must enter a csv file."); // not validating file, ensuring it is a csv file

			} else { // if file does end with csv, do the below

				pokeDexFile = new File(dexPath); // if it is not null, MAKE a file & therefore NOT null
													// below we check to see if this file is valid
				if (!pokeDexFile.exists()) {
					System.out.println("You must enter an existing pokeDex file.");
					pokeDexFile = null; // if the file doesn't exist, set to null
				} else if (!pokeDexFile.isFile()) {
					System.out.println("You must enter a file not a directory.");
					pokeDexFile = null;// if not a file, set file to null
				} else if (!pokeDexFile.canRead()) {
					System.out.println("You must enter a pokeDex file we can read.");
					pokeDexFile = null;// if file cannot be read, set file to null
				}
			}
		}
		return pokeDexFile;
	}

	
	private static void printFlowerBox(int numberRows) {
		for (int i = 0; i < numberRows; i++) {
			System.out.println("*******************************************");
		}
	}

	private static void printWelcomeMessage() {
		int boxSize = 3;
		printFlowerBox(boxSize);
		System.out.println("Welcome to the PokeDex 2000.");
		printFlowerBox(boxSize);
		System.out.println("\n\n\n");
	}
	
	//MAIN METHOD
	public static void main(String[] args) { // user input & user reading
		// main is the point of composition, where it all comes together

		Scanner userInput = new Scanner(System.in);

// print welcome method

		printWelcomeMessage();
// prompt for pokedex source (CSV file)
		File pokeDexFile = promptForPokeDexFile(userInput);
// call a module that loads the pokedex
		CsvLoader loader = new CsvLoader(pokeDexFile);
		Map<Integer, Pokemon> realPokeDex = loader.loadPokeDex();

// print a menu for access to pokemon by number

//

	}

}
