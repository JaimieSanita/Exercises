package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class MaxEnd3Test {
	
	// MakeArray([1, 2, 3]) → [3, 3, 3]
	// MakeArray([11, 5, 9]) → [11, 11, 11]
	// MakeArray([2, 11, 3]) → [3, 3, 3]
	//null
	
	@Test
	public void larger_third() {
		MaxEnd3 test = new MaxEnd3();
		int[] expectedNums = {1, 2, 3};
		int[] expectedResult = {3, 3, 3};
		
		int[] actualResult = test.makeArray(expectedNums);
		
		Assert.assertEquals("When the third element of the array is larger than the first, all elements in array should be set to that value.",
				expectedNums, 
				actualResult);
		
		
	}
	
	@Test
	public void larger_first() {
		MaxEnd3 test = new MaxEnd3();
		int[] expectedNums = {11, 5, 9};
		int[] expectedResult = {11, 11, 11};
		
		int[] actualResult = test.makeArray(expectedNums);
		
		Assert.assertEquals("When the first element of the array is larger than the third, all elements in array should be set to that value.",
				expectedNums, 
				actualResult);
		
		
	}
	
	@Test
	public void largerest_second_larger_third() {
		MaxEnd3 test = new MaxEnd3();
		int[] expectedNums = {2, 11, 3};
		int[] expectedResult = {3, 3, 3};
		
		int[] actualResult = test.makeArray(expectedNums);
		
		Assert.assertEquals("When the third element of the array is larger than the first, all elements in array should be set to that value.",
				expectedNums, 
				actualResult);
		
		
	}
	
	@Test
	public void array_not_null() {
		MaxEnd3 test = new MaxEnd3();
		int[] expectedNums = null;
		
		
		int[] actualResult = test.makeArray(expectedNums);
		
		Assert.assertNotNull("The int array should not be null.",
				expectedNums);
		
		
	}
	
	
	

}
