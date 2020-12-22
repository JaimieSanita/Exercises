package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class NonStartTest {
	
	//GetPartialString("Hello", "There") → "ellohere"
    //GetPartialString("java", "code") → "avaode"
    //GetPartialString("shotl", "java") → "hotlava"
	//string empty
	//string null
	
	@Test
	public void partial_string_works_hello_there() {
		NonStart testing = new NonStart();
		
		String expectedA = "Hello";
		String expectedB = "There";
		String expectedResult = "ellohere";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertEquals("Concatenate but omit first character of each. Expected ellohere.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void partial_string_works_java_code() {
		NonStart testing = new NonStart();
		
		String expectedA = "java";
		String expectedB = "code";
		String expectedResult = "avaode";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertEquals("Concatenate but omit first character of each. Expected avaode.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void partial_string_works_shotl_java() {
		NonStart testing = new NonStart();
		
		String expectedA = "shotl";
		String expectedB = "java";
		String expectedResult = "hotlava";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertEquals("Concatenate but omit first character of each. Expected hotlava.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void partial_string_works_length_1() {
		NonStart testing = new NonStart();
		
		String expectedA = "Hi";
		String expectedB = "U";
		String expectedResult = "i";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertEquals("Concatenate but omit first character of each. Expected i",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void partial_string_works_a_empty() {
		NonStart testing = new NonStart();
		
		String expectedA = "";
		String expectedB = "There";
		String expectedResult = "here";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertEquals("If string A is length 0, return string B omitting first character. Expected here.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void partial_string_works_b_empty() {
		NonStart testing = new NonStart();
		
		String expectedA = "Hello";
		String expectedB = "";
		String expectedResult = "ello";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertEquals("If string B is length 0, return string A omitting first character. Expected ello.",
				expectedResult, 
				actualResult);
	}
	/** Should include?
	@Test
	public void partial_string_not_null() {
		NonStart testing = new NonStart();
		
		String expectedA = null;
		String expectedB = "";
		String expectedResult = "unknown";
		
		String actualResult = testing.getPartialString(expectedA, expectedB);
		
		Assert.assertNotNull("Strings should not be null.", actualResult);
		
		
	}
	
	**/

}
