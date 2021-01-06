package com.techelevator;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.pokemon.Pokemon;

public class Program {

	private static File validateCsvPath(String pathToCSV) {
		File csvFile = new File(pathToCSV);
		if (!csvFile.exists()) {
			System.out.println("You must enter an existing pokedex file");
			csvFile = null;
		} else if (!csvFile.isFile()) {
			System.out.println("You must enter a file, not a directory");
			csvFile = null;
		} else if (!csvFile.canRead()) {
			System.out.println("You must give us a pokedex file we can read");
			csvFile = null;
		}

		return csvFile;
	}

	private static File promptForPokedexFile(Scanner inputScanner) {

		File pokedexFile = null;
		while (pokedexFile == null) {

			System.out.print("Enter the csv file for your pokedex: >>> ");
			String dexPath = inputScanner.nextLine();

			if (!dexPath.endsWith("csv")) {
				System.out.println("You must enter a csv file");
			} else {
				// Lets set up our candidate file, we'll set it back to null if the file is
				// invalid later
				pokedexFile = validateCsvPath(dexPath);
			}

		}

		return pokedexFile;
	}

	private static void printFlowerBox(int numberRows) {
		for (int i = 0; i < numberRows; i++) {
			System.out.println("********************************");
		}
	}

	private static void printWelcomeMessage() {
		int boxSize = 3;
		printFlowerBox(boxSize);
		System.out.println("Welcome to the PokeDex 2000");
		printFlowerBox(boxSize);
		System.out.println("\n\n\n");
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		// print welcome method

		printWelcomeMessage();

		// prompt them for a pokedex source (CSV file)
		File pokeDexFile = promptForPokedexFile(userInput);

		// call a module that loads the pokedex
		CsvLoader loader = new CsvLoader(pokeDexFile);
		Map<Integer,Pokemon> realPokedex = loader.loadPokedex();
		
		// print a menu for them to access pokemon by number

	}
}
