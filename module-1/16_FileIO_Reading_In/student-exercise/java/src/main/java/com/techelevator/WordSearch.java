package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// use file object to validate object is good - exists, not file
	// use try resource block out of file
	// while loop over file
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {

		File inputFile = getInputFileFromUser();
		String wordSearch = getWordSearch();
		
		
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
		
			int lineNumber = 1;
			
			while(fileScanner.hasNextLine()) {
				
				String line = fileScanner.nextLine();
				if(line.contains(wordSearch)) {
					
					
					
					System.out.println(lineNumber + ") " + line);
					
				} 
				lineNumber++;
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in); // scanner
		System.out.println("What is the file that should be searched?");
		String path = userInput.nextLine(); // will read next line of user as a string

		File inputFile = new File(path); // construct file object using path provided from user

		if (!inputFile.exists()) {
			System.out.println(path + " does not exist.");
			System.exit(1);
		} else if (!inputFile.isFile()) {
			System.out.println(path + " is not a file.");
			System.exit(1);
		} else if (!inputFile.canRead()) {
			System.out.println(path + " can not be read.");
			System.exit(1);
		}
		return inputFile;
	}

	private static String getWordSearch() {
		Scanner userString = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String wordSearch = userString.nextLine();
		return wordSearch;
		
		
	}

	
}
