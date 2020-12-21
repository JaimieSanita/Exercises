package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class Less20Test {
	
	//less20(18) → true*
    //less20(19) → true*
    //less20(20) → false*
	//less20(-19) at false*
	
	@Test
	public void one_less_multiple() {
		Less20 multiple = new Less20();
		int expectedValue = 19;
		boolean expectedResult = true;
		
		boolean actualResult = multiple.isLessThanMultipleOf20(expectedValue);
		
		Assert.assertTrue("The provided number should be one less than a multiple of 20.",
				actualResult);
	}
	
	@Test
	public void two_less_multiple() {
		Less20 multiple = new Less20();
		int expectedValue = 18;
		boolean expectedResult = true;
		
		boolean actualResult = multiple.isLessThanMultipleOf20(expectedValue);
		
		Assert.assertTrue("The provided number should be one two than a multiple of 20.",
				actualResult);
	}
	
	@Test
	public void is_multiple_20() {
		Less20 multiple = new Less20();
		int expectedValue = 20;
		boolean expectedResult = false;
		
		boolean actualResult = multiple.isLessThanMultipleOf20(expectedValue);
		
		Assert.assertFalse("The provided number is not one less or two less than a multiple of 20.",
				actualResult);
	}
	
	@Test
	public void is_negative() {
		Less20 multiple = new Less20();
		int expectedValue = -19;
		boolean expectedResult = false;
		
		boolean actualResult = multiple.isLessThanMultipleOf20(expectedValue);
		
		Assert.assertFalse("The provided number cannot be negative.",
				actualResult);	
	}

}
