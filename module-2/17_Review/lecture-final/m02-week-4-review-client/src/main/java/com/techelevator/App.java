package com.techelevator;

import com.techelevator.services.ConsoleService;

public class App {

	//fields/variables
	private ConsoleService console;
	
	//constructors
	
	public App(ConsoleService consoleService) {
		this.console = consoleService;
	}
	
	//methods
	
	//central loop to prompt them with a menu
	// then delegate out to other functionality
	public void run() {
		int returnCode;
		do {
			returnCode = console.printMainMenu();
			
		} while(returnCode > 0);
	}
	
	
	
	
	// MAIN IS STATIC, does not need a new App to work
	public static void main(String[] args) {
		// construct any dependencies I need
		ConsoleService cService = new ConsoleService();
		
		// create an instance of the class
		App app = new App(cService);
		
		// start the application logic by calling the run method on the class
		app.run();
	}
}
