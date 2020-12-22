package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class FrontTimesTest {
	
	
	 // frontTimes("Chocolate", 2) →"ChoCho" *
	 // frontTimes("Chocolate", 3) → "ChoChoCho" *
	 // frontTimes("Abc", 3) → "AbcAbcAbc"*
	//frontTimes("Chocolate", -5) at chocolate?* CORRECT?
	//string is null* 
	
	@Test
	public void two_string_return() {
		FrontTimes fronting = new FrontTimes();
		
		String expectedString = "Chocolate";
		int expectedNumber = 2;
		String expectedResult = "ChoCho";
		
		String actualResult = fronting.generateString(expectedString, expectedNumber);
		
		Assert.assertEquals("The result should be ChoCho.",
				expectedResult, 
				actualResult);
		
	}
	
	@Test
	public void three_string_return() {
		FrontTimes fronting = new FrontTimes();
		
		String expectedString = "Chocolate";
		int expectedNumber = 3;
		String expectedResult = "ChoChoCho";
		
		String actualResult = fronting.generateString(expectedString, expectedNumber);
		
		Assert.assertEquals("The result should be ChoChoCho.",
				expectedResult, 
				actualResult);
		
	}

	
	@Test
	public void string_less_than_three_return() {
		FrontTimes fronting = new FrontTimes();
		
		String expectedString = "Abc";
		int expectedNumber = 3;
		String expectedResult = "AbcAbcAbc";
		
		String actualResult = fronting.generateString(expectedString, expectedNumber);
		
		Assert.assertEquals("The result should be AbcAbcAbc.",
				expectedResult, 
				actualResult);
		
	}
	
	
	@Test
	public void string_not_null() {
		FrontTimes fronting = new FrontTimes();
		
		String expectedString = null;
		int expectedNumber = 3;
		String expectedResult = "";
		
		String actualResult = fronting.generateString(expectedString, expectedNumber);
		
		Assert.assertNotNull("The string provided should not be null.", actualResult);
		Assert.assertEquals("If the string provided is null, should return empty string.",
				expectedResult, 
				actualResult);
		
	}
	//SHOULDN'T PASS BECAUSE NOTHING IN PLACE FOR NEGATIVE NUMBER IN METHOD
	@Test
	public void negative_n_copies() {
		FrontTimes fronting = new FrontTimes();
		
		String expectedString = "Abc";
		int expectedNumber = -3;
		
		String actualResult = fronting.generateString(expectedString, expectedNumber);
		
		Assert.fail("There cannot be a negative value for n.");
		
	}
}
