package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter the path of a file or directory >>> ");
		String providedPath = userInput.nextLine();
		
		File f = new File(providedPath);
		
		
		//empty print line for spacing
		System.out.println();
		
		
		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */
		
		
		// Given a file object, we can explore the file system
		
		/***
		 * Reading attributes about a file or the file system in general
		 */
		
		if(f.exists()) {
			System.out.println("Name: " + f.getName());
			System.out.println("Absolute Path: " + f.getAbsolutePath());
			
			if(f.isDirectory()) {
				System.out.println("Type: Directory");
			} else if (f.isFile()) {
				System.out.println("Type: File");
			}	
		} else {
			System.out.println("That file does not exist");
		}
		
		
		System.out.println();
		
		/***
		 * 
		 * Manipulating the filesystem
		 * 
		 * 
		 */
		
		System.out.println("Great! Now lets create a new directory");
		System.out.print("Enter the path of the new directory >>> ");
		String newDirectoryPath = userInput.nextLine();
		
		File newDirectory = new File(newDirectoryPath);
		
		if(newDirectory.exists()) {
			
			// if it already exists, nothing to do, bail out
			System.out.println("Sorry, "  + newDirectory.getAbsolutePath() + " already exists!");
			System.exit(1);
		} else {
			
			if(newDirectory.mkdir()) {
				System.out.println("New directory created at: " + newDirectory.getAbsolutePath());
			} else {
				System.out.println("Unable to create directory");
				System.exit(1);
			}
		}
		
		
		System.out.println();
		
		/**
		 * 
		 * Manipulating the filesystem - creating files
		 * 
		 */
		
		
		System.out.println("Great! Lets make a new file in the new directory");
		System.out.print("Enter the name for the new file >>> ");
		String newFilePath = userInput.nextLine();
		
		
		//   same    =            directory                   ,  fileName
		File newFile = new File(newDirectory.getAbsolutePath(), newFilePath);
		
		if(newFile.exists()) {
			System.out.println("The new file exists already!");
			System.exit(1);
		} else {
			try {
				if(newFile.createNewFile()) {
					System.out.println("name: " + newFile.getName());
					System.out.println("absolute path: " + newFile.getAbsolutePath());
					System.out.println("size: " + newFile.length());
				} else {
					System.out.println("Unable to create the file!");
					System.exit(1);
				}
			} catch(IOException ioe) {
			
				
				System.out.println("We failed trying to create the new file");
				
				System.exit(1);
			}
		}
		
		/**
		 * 
		 * Writing to a file
		 * 
		 */
	
		System.out.println();
		System.out.println("Ok! Lets write something to the file");
		System.out.print("Enter a message >>> ");
		String message = userInput.nextLine();

		
		try(PrintWriter writer = new PrintWriter(newFile)) {
			
			writer.println(message);
			
			
		} catch(FileNotFoundException fnf) {
			System.out.println("Couldn't open the file to write to it!");
			System.exit(1);
		}
		
		System.out.println("We finished writing our files");
		
		
		
		/**
		 * 
		 * 
		 * Old skooool
		 * 
		 * File writer doesn't have any of the nice things we get in print writer
		 * so we prefer to use print writer directly
		 * 
		 * one little useage you can hand a filewriter into print writer though
		 * 
		 * You may see this if you google for things
		 * 
		 * Still, generally prefer just making a print writer in a try/resource block like above
		 * 
		 */
		
		FileWriter fw = new FileWriter(newFile);
		
		// exception, if you need a print writer to flush on every line
		
		// this print writer will flush after every line
		try(PrintWriter autoFlushPrintWriter = new PrintWriter(fw, true)) {
			autoFlushPrintWriter.println("Here's a line");
			userInput.nextLine();
			autoFlushPrintWriter.println("Here's another line");
		}
		

	}

}
