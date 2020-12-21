package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class AnimalGroupNameTests {
	//recreate animalgroupname method to test off of
	
	//test Map accepting String, String
	//test String isn't null*
	//test empty String*
	//test large String
	//test limits of datatypes passing in
	//test case insensitive*
	//test proper return*
	//test animal name doesn't exist in map
	
	
	
	@Test //happy path
	public void get_herd_works() {
		//ARRANGE; create new class
		AnimalGroupName copyOfClass = new AnimalGroupName(); //constructor is empty
		
		String animalName = "rhino";
		String expectedGroup = "Crash";
		
		//ACT; when pass rhino through getHerd() method should receive Crash
		String actualGroup = copyOfClass.getHerd(animalName);
		
		//ASSERT
		Assert.assertEquals("The animal provided should return proper group.",
				expectedGroup,
				actualGroup);
	}
	
	@Test
	public void animal_name_does_not_exist() {
		AnimalGroupName copyOfClass = new AnimalGroupName();
		String providedName = "cat";
		String expectedGroup = "unknown";
				
		String actualGroup = copyOfClass.getHerd(providedName);
		
		Assert.assertEquals("The animal name provided does not exist",
				expectedGroup, 
				actualGroup);
		
	}
	
	
	@Test
	public void string_not_null() {
	
		//ARRANGE
			//setup Map?
		AnimalGroupName copyOfClass = new AnimalGroupName();
		String stringIsNull = null;
		//ACT
			//get String
		String actualValue = copyOfClass.getHerd(stringIsNull);
			
		//ASSERT
			//asserttrue/false
		Assert.assertNotNull("String should not be null.", 
				actualValue);
		Assert.assertEquals("If animal name is null, return Unknown for group name.",
				"unknown",
				actualValue);
	}
	
	@Test
	public void string_not_empty() {
		//Arrange
		AnimalGroupName copyOfClass = new AnimalGroupName();
		String stringIsEmpty = "";
		//Act
		String actualString = copyOfClass.getHerd(stringIsEmpty);
		//Assert
		Assert.assertEquals("If string is empty, return unknown.",
				"unknown",
				actualString);
	}
	
	@Test
	public void string_case_insensitive() {
		//Arrange
		AnimalGroupName copyOfClass = new AnimalGroupName();
		String providedString = "Rhino";
		String expectedGroup = "Crash";
		
		
		//Act
		String actualString = copyOfClass.getHerd(providedString);
		
		//Assert
		Assert.assertEquals("The animal name should be case insensitive.",
				expectedGroup, actualString);
		
		
	}
	
	

	
	

	

}
