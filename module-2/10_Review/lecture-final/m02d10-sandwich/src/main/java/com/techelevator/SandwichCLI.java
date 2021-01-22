package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.ExerciseDAO;
import com.techelevator.model.jdbc.JDBCExerciseDAO;
import com.techelevator.view.Menu;

public class SandwichCLI {
	
	private static final String MAIN_MENU_LIST_ALL = "Show our sandwiches";
	private static final String MAIN_MENU_ADD = "Add a sandwich";
	private static final String MAIN_MENU_UPDATE = "Update a sandwich";
	private static final String MAIN_MENU_ADD_CATEGORY = "Add or remove a category from a sandwich";
	private static final String MAIN_MENU_EXIT = "Exit the application";
	
	private Menu menu;
	
	private static final String[] MAIN_MENU_OPTIONS = {
			MAIN_MENU_LIST_ALL,
			MAIN_MENU_ADD,
			MAIN_MENU_UPDATE,
			MAIN_MENU_ADD_CATEGORY,
			MAIN_MENU_EXIT};
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_LIST_ALL)) {
				System.out.println("******Menu goes here******");
			}else if(choice.equals(MAIN_MENU_EXIT)) {
				System.out.println("Goodbye");
				System.exit(0);
			}
		}
	}

	public SandwichCLI() {
		// make a new datasource
		BasicDataSource dataSource = new BasicDataSource();
		
		//what database do I connect to
		dataSource.setUrl("jdbc:postgresql://localhost:5432/sandwhich_shop");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		

		//TODO create my DAO object
		
		// setup the menu object for printing
		this.menu = new Menu(System.in,System.out);
		
	}
	
	public static void main(String[] args) {
		SandwichCLI cli = new SandwichCLI();
		cli.run();
	}
}
