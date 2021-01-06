package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		// create file to store results of FizzBuzz

		File newFile = new File("FizzBuzz.txt");

		// write to new file

		try (PrintWriter writer = new PrintWriter(newFile)) {
			// write out the result of FizzBuzz (1 to 300)

			// If the number is divisible by 3 or contains a 3, print “Fizz.”
			// If the number is divisible by 5 or contains a 5, print “Buzz.”
			// If the number is divisible by 3 and 5, print “FizzBuzz.”
			// Otherwise, print the number.
			boolean divisibleThree;
			boolean divisibleFive;

			for (int i = 1; i <= 300; i++) { //line starts at 1
				divisibleThree = i % 3 == 0;
				divisibleFive = i % 5 == 0;
				if (divisibleThree && divisibleFive) {
					writer.println("FizzBuzz");
				} else if (divisibleThree) {
					writer.println("Fizz");
				} else if (divisibleFive) {
					writer.println("Buzz");
				} else {
					writer.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			System.exit(1);
			e.printStackTrace();
		}

	}

}
