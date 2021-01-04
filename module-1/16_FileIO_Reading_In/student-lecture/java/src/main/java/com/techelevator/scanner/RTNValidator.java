package com.techelevator.scanner;


import java.io.File; //file class which represents a file in the operating systems file tree
import java.io.FileNotFoundException; //an error that occurs when our code accesses a file that does not exist
import java.util.Scanner; //utility class for representing a stream of characters
						  //doesn't care if stream of characters is from a file or from the command line (user input)

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException { //checked exception must be handled in try/catch OR 
																		 //mark method with THROWS keyword
																		//means I'm not dealing with this exception

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		
		
		
		
		//TRY RESOURCE BLOCK
		//use for anything that is capable of closing
		//special try/catch block
		//use when resource working with implements Closeable interface
		//we can declare resource in a set of ()
		//after the try
		//java will automatically add a finally {} block
		//that closes the underlying resource
	
		try  (Scanner fileScanner = new Scanner(inputFile)){
			
			//scanner behave the scame on files or on text streams
			while(fileScanner.hasNextLine()) { // while this condition is true, do the below
				
				//notice nextLine works just like when we used the command line
				String line = fileScanner.nextLine(); // pull next line of file
				String rtn = line.substring(0, 9); // take first 9 characters of nexline of file
				
				if(!checksumIsValid(rtn)) { //if valid method doesn't come back true/correct
					System.out.println(line); //print full line
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
		
		//WARNING
		//do not use TRY RESOURCE BLOCK with a scanner for System.in
		//if do, you lose ability to read from command line until you close the program
		//because System.in is defined by our program & is not an outside world resource
		Scanner userInput = new Scanner(System.in); //System.in represents stream of characters from the console
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path); //create file object that accepts string of path to the file
										//underlying file working with exists outside the program; therefore when we create & open file object
										//we have reference to something that exists outside Java Operating Machine
										//Java garbage collector can not clean up because outside
										//once file opened, "locked", exclusively open for you & no one else can open until file closed
	
		
		
		
		if(!inputFile.exists()) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
							//System.exit(0) exits program successfully
							//System.exit(1) exits program unsuccessfully
		} else if(!inputFile.isFile()) { //could be folder instead of file
			System.out.println( path + " is not a file");
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
