package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.ExerciseDAO;
import com.techelevator.model.jdbc.JDBCExerciseDAO;

public class ExerciseApp {

	private ExerciseDAO sampleDAO = null;
	
	public static void main(String[] args) {
		ExerciseApp exerciseApp = new ExerciseApp();
		
		// TODO The rest of the application :-)
	}
	
	public ExerciseApp(){
		// Sample definition for a PostgreSQL database named "sample" hosted on localhost at port 5432
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/sample");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		// Create an instance of the SampleDAO
		sampleDAO = new JDBCExerciseDAO(dataSource);
	}

}
