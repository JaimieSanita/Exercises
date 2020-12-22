package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


public class SameFirstLastTest {
	
	//IsItTheSame([1, 2, 3]) → false *
    //IsItTheSame([1, 2, 3, 1]) → true *
    //IsItTheSame([1, 2, 1]) → true *
	//null *
	//empty *

	@Test
	public void same_first_last_works_3_elements () {
		SameFirstLast test = new SameFirstLast();
		int[] expectedArray = {1, 2, 1};
		boolean expectedResult = true;
		
		boolean actualResult = test.isItTheSame(expectedArray);
		
		Assert.assertTrue("Expected true. The length of arryay is 1 or greater and first and last elements equal.", actualResult);
		
		
	}
	

	@Test
	public void same_first_last_works_4_elements () {
		SameFirstLast test = new SameFirstLast();
		int[] expectedArray = {1, 2, 3, 1};
		boolean expectedResult = true;
		
		boolean actualResult = test.isItTheSame(expectedArray);
		
		Assert.assertTrue("Expected true. Array length is 1 or more and the first and last elements are equal.", actualResult);
		
		
	}
	

	@Test
	public void same_first_last_3_not_equal () {
		SameFirstLast test = new SameFirstLast();
		int[] expectedArray = {1, 2, 3};
		boolean expectedResult = false;
		
		boolean actualResult = test.isItTheSame(expectedArray);
		
		Assert.assertFalse("Expected false. The first and last elements of the array are not equal.", actualResult);
		
		
	}
	

	@Test
	public void same_first_last_not_null () {
		SameFirstLast test = new SameFirstLast();
		int[] expectedArray = null;
		boolean expectedResult = false;
		
		boolean actualResult = test.isItTheSame(expectedArray);
		
		Assert.assertFalse("Expected false.  Array cannot be null.", actualResult);
		
		
	}
	

	@Test
	public void same_first_last_works_0_elements () {
		SameFirstLast test = new SameFirstLast();
		int[] expectedArray = {};
		boolean expectedResult = false;
		
		boolean actualResult = test.isItTheSame(expectedArray);
		
		Assert.assertFalse("Expected false. Array is empty.", actualResult);
		
		
	}
}
