package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in); // do not want a try resource block because using system.in

		System.out.print("Enter the path of a file or directory >>>");
		String providedPath = userInput.nextLine(); // read next string off of program

		System.out.println();

		File f = new File(providedPath); // resource hasn't been created yet

		// Given a file object, we can explore the file system

		// READING ATTRIBUTES ABOUT A FILE OR THE FILE SYSTEM IN GENERAL
		// because there is no scanner, this file has not been read & therefore does not
		// need to be closed
		if (f.exists()) {
			System.out.println("Name: " + f.getName());
			System.out.println("Absolute Path: " + f.getAbsolutePath());
			if (f.isDirectory()) {
				System.out.println("Type: Directory");
			} else if (f.isFile()) {
				System.out.println("Type: File");
			}
		} else {
			System.out.println("That file does not exist.");
		}

		/***
		 * 
		 * MANIPULATING THE FILE SYSTEM
		 * 
		 * 
		 */

		System.out.println("Great! Now let's create a new directory.");
		System.out.print("Enter the path of the new directory >>>");

		String newDirectoryPath = userInput.nextLine(); // reusing userInput scanner to get new path to directory

		File newDirectory = new File(newDirectoryPath); // to create a new directory, must use File class with a path

		if (newDirectory.exists()) { // must check to see if newDirectory exists
			System.out.println("Sorry, " + newDirectory.getAbsolutePath() + " already exists."); // by showing
																									// absolutePath is
																									// best practice
			System.exit(1); // exit out of code unsuccessfully because newDirectory already existed
		} else {
			if (newDirectory.mkdir()) { // if I can make a directory, print path below; nothing needs to be closed when
										// creating
										// operating system creates space for directory/folder
				System.out.println("New Directory created at: " + newDirectory.getAbsolutePath());
			} else {
				System.out.println("Unable to create directory.");
				System.exit(1);
			}
		}

		System.out.println();

		/*
		 * 
		 * MANIPULATING THE FILESYSTEM - CREATING FILES
		 * 
		 */

		System.out.println("Great! Let's make a new file in the new directory.");
		System.out.print("Enter the name for the new file >>>");
		String newFilePath = userInput.nextLine();

		// want to create new file to go into directory made up above

		// Class //name //create memory for // //directory to put file //name of file
		File newFile = new File(newDirectory.getAbsolutePath(), newFilePath); // take 2 pieces, the path & file name

		if (newFile.exists()) {
			System.out.println("The new file exists already.");
			System.exit(1);
		} else {
			try {
				if (newFile.createNewFile()) {
					System.out.println("Name: " + newFile.getName());
					System.out.println("Absolute Path: " + newFile.getAbsolutePath());
					System.out.println("Size: " + newFile.length());
				} else {
					System.out.println("Unable to create the file!");
					System.exit(1);
				}

			} catch (IOException ioe) {
				System.out.println("Exception trying to create the new file.");
				System.exit(1);
			}
		}

		/**
		 * 
		 * WRITING TO A FILE
		 * 
		 */

		System.out.println();
		System.out.println("Ok! Let's write something to the file.");
		System.out.print("Enter a message >>>");
		String message = userInput.nextLine();
		
		
		//TRY RESOURCE BLOCK TO WRITE TO FILE
		//closes out file automatically & thus flushes automatically
			// class to write 					//take file
		try (PrintWriter writer = new PrintWriter(newFile)) {

			writer.println(message); // prints message into file; will save up change & not immediately write changes to disk
									// try resource block will flush contents
			
		
			//WRITER FLUSH
		//	writer.flush(); // if keeping log can't use try resource block & will need to use .flush to force writing to disk
							//take everything logged & write to disk
							//put flush in place to ensure changes are written to disk
							//when writing to stream, it is not written immediately, it is buffered
							//buffer is temp memory location
							//flushes output stream & forces any output bytes to be written out
							//write to destination
		
			
		} catch (FileNotFoundException fnf) {
			System.out.println("Couldn't open the file to write to it.");
			System.exit(1);
		}
		System.out.println("We finished writing our files.");
		
		/***
		 * 
		 * 
		 * Old method
		 * 
		 * File writer doesn't have any of the nice things we get in the print writer
		 * so we prefer to use print writer directly
		 * 
		 * one little usage you can hand a filewriter into print writer though
		 */

		FileWriter fw = new FileWriter(newFile);
		
		//AUTOFLUSH ON EVERY LINE
		//exception, if you need a print writer to flush on every line
		//this printwriter will flush after everyline
		try(PrintWriter autoFlushPrintWriter = new PrintWriter(fw, true)) {
			autoFlushPrintWriter.println("Here's a line.");
			userInput.nextLine();
			autoFlushPrintWriter.println("Here's another line.");
		}
			
		}
		
		/*
		 * The java.io.File class is a representation of file and directory path names.
		 * It provides methods to inspect and modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of
		 * '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file
		 * system path
		 */
	}

