package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {

		File inputFile = getInputFileFromUser();
		String wordSearch = getWordSearch();
		boolean sensitive = makeCaseSensitive();

		try (Scanner fileScanner = new Scanner(inputFile)) {

			for (int lineNumber = 1; fileScanner.hasNextLine(); lineNumber++) {

				String line = fileScanner.nextLine();

				if (sensitive && line.contains(wordSearch)) {

					System.out.println(lineNumber + ") " + line);

				} else if (!sensitive && line.toLowerCase().contains(wordSearch)) {
					System.out.println(lineNumber + ") " + line);
				}

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
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String wordSearch = userInput.nextLine();
		return wordSearch;

	}

	private static boolean makeCaseSensitive() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Should the search be case sensitive? Enter: Y or N");
		String sensitive = userInput.nextLine();
		if (sensitive.contains("y") || sensitive.contains("Y")) {
			return true;
		} else {

			return false;
		}
	}
}
