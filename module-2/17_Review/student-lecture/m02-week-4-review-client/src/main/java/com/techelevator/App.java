package com.techelevator;

import com.techelevator.services.ConsoleService;

public class App {

	// VARIABLES
	private ConsoleService console;

	// CONSTRUCTOR
	public App(ConsoleService consoleService) {
		this.console = consoleService;
	}

	// METHODS
	//central loop to prompt with a menu
	//then delegate out to other functionality
	public void run() {  
		int returnCode;
		do {
			returnCode = console.printMainMenu(); //show menu at least once
		} while (returnCode > 0); // loop if this is true

	}

	//MAIN IS STATIC;
	public static void main(String[] args) {
		// construct any dependencies needed
		ConsoleService cService = new ConsoleService();
		
		//creating instance of class
		App app = new App(cService);
		
		//starts the application logic by calling the run method on the class
		app.run();

	}

}
