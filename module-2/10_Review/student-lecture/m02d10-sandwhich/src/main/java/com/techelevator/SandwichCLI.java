package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.ExerciseDAO;
import com.techelevator.model.jdbc.JDBCExerciseDAO;
import com.techelevator.view.Menu; //imported menu class

public class SandwichCLI {
	//constant variables
	private static final String MAIN_MENU_LIST_ALL = "Show our menu";
	private static final String MAIN_MENU_ADD = "Add a sandwich";
	private static final String MAIN_MENU_UPDATE = "Update a sandwich.";
	private static final String MAIN_MENU_ADD_CATEGORY = "Add or remove a category from a sandwich.";
	private static final String MAIN_MENU_LIST_EXIT = "Exit the application.";
	
	//need menu object
	private Menu menu;
	
	private static final String[] MAIN_MENU_OPTIONS = {
			MAIN_MENU_LIST_ALL,
			MAIN_MENU_ADD,
			MAIN_MENU_UPDATE,
			MAIN_MENU_ADD_CATEGORY,
			MAIN_MENU_LIST_EXIT};
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);//returns object and must cast as String
			if(choice.equals(MAIN_MENU_LIST_ALL)) {
				System.out.println("Menu goes here.");
			} else if (choice.equals(MAIN_MENU_LIST_EXIT)) {
				System.out.println("Goodbye.");
				System.exit(0);
			}
		}
	}
	
	public SandwichCLI() {
		//make new datasource
		BasicDataSource dataSource = new BasicDataSource();
		//what database NAME to connect to
		dataSource.setUrl("jdbc:postgresql://localhost:5432/sandwhich_shop");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		//TODO create my DAO object

		//TODO setup the menu object for printing
		this.menu = new Menu(System.in, System.out);//need inputstream and output stream; 
													//if testing, a scanner built off string
													//output would be a buffer
	}
	
	public static void main(String[] args) {
		SandwichCLI cli = new SandwichCLI(); //constructed object
		cli.run(); //called run method
		
	}

}
