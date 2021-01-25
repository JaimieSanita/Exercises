package com.techelevator.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.*; //IMPORT ALL 

public class JDBCSandwichDAOTest {
	
	//NEED CONNECTION TO DATABASE & ALWAYS WANT STAND ALONE PER CLASS
	//therefore tests don't affect other tests
	private static SingleConnectionDataSource dataSource;//must be connected to database
	
	
	//CONSTANTS; for making dummy record
	private static final int SANDWICH_ID = 1235567890; //sandwich_id is serial, and set to unlikely serial id there safe to insert value
	private static final String SANDWICH_NAME = "Test_Sandwich"; //only need constants that are necessary for methods
	
	private static final int CATEGORY_ID = 999999999;
	private static final String CATEGORY_NAME = "Some Category";
	
	//CLASS VARIABLES
	
	SandwichDAO dao;
	@BeforeClass //has to happen before class is instantiated
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/sandwhich_shop");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false); //open transaction & ultimately roll it back b/c test
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before //happens once per test
	public void setup() {
		this.dao = new JDBCSandwichDAO(dataSource); //jdbc is class that implements dao interface; initializes dao
		//could use create method
		//TODO create any records necessary
	}
	
	@After
	public void tearDown() throws SQLException { //throwing exception ok b/c Sql based 
		dataSource.getConnection().rollback(); //need to .connect to .rollback
	}

	@Test
	public void load_sandwich_by_id() {
		//ARRANGE
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String insertQuery = "INSERT INTO menu(id, name, description, is_available) " +
							 "VALUES(?,?,?,?)";
		template.update(insertQuery, SANDWICH_ID, SANDWICH_NAME, "SOME DESCRIPTION", true); //pick boolean that isn't default(which is false for this example)
		//ACT; get sandwich with constant identifier off of DAO; getting object back
		Sandwich actual = this.dao.getById(SANDWICH_ID); //Sandwich has an id and name
		//ASSERT (may not need all of these, preference)
		Assert.assertNotNull("Sandwich should be in the database and not null", actual); //checks object isn't empty or null
		assertEquals("Sandwich id should match", SANDWICH_ID, actual.getId()); //sandwich object should have id set on it that matches
		assertEquals("Name should match", SANDWICH_NAME, actual.getName()); //checks the sandwich name match
		Assert.assertTrue("Sandwich should be available.", actual.isAvailable());
		Assert.assertNotNull("The description should not be empty", actual.getDescription());
		Assert.assertTrue("Descriptoin shouldn't be empty.", actual.getDescription().length() > 0);
	}
}
