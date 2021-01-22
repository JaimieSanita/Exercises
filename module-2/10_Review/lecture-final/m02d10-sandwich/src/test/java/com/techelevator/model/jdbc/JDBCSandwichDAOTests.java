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

import com.techelevator.model.*;

public class JDBCSandwichDAOTests {

	private static SingleConnectionDataSource dataSource;
	
	// constants for making a dummy record
	private static final int SANDWICH_ID = 1234567890;
	private static final String SANDWICH_NAME = "Test Sandwich";
	
	private static final int CATEGORY_ID = 999999999;
	private static final String CATEGORY_NAME = "Some Category";
	
	// Before/after almost always come as a pair
	// before sets up, after cleans up 
	
	// class variables

	SandwichDAO dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/sandwhich_shop");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		// we want to do all the tests in transactions
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		this.dao = new JDBCSandwichDAO(dataSource);
		//TODO create any records I need
	}
	
	@After
	public void teardown() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void load_sandwich_by_id() {
		// arrange
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String insertQuery = "INSERT INTO menu(id,name,description,is_available) " +
				             "VALUES (?,?,?,?)";
		template.update(insertQuery,SANDWICH_ID, SANDWICH_NAME, "Some description", true);
		
		// act
		Sandwich actual = this.dao.getById(SANDWICH_ID);
		
		// assert
		Assert.assertNotNull("Sandwich should be in the database and not null", actual);
		assertEquals("Sandwich id should match",SANDWICH_ID, actual.getId());
		assertEquals("Name should match", SANDWICH_NAME, actual.getName());
		Assert.assertTrue("Sandwich should be available",actual.isAvailable());
		Assert.assertNotNull(actual.getDescription());
		Assert.assertTrue("Description shouldn't be empty", actual.getDescription().length() > 0 );
		
	}
	
}
