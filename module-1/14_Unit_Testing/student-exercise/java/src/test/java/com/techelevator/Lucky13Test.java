package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class Lucky13Test {
	
	//GetLucky([0, 2, 4]) → true *
	//GetLucky([1, 2, 3]) → false *
	//GetLucky([1, 2, 4]) → false*
	//null*
	
	@Test
	public void no_one_or_three() {
		Lucky13 lucky = new Lucky13();
			int[] expectedArray = {0, 2, 4};
			boolean expectedResult = true;
			
			boolean actualResult = lucky.getLucky(expectedArray);
			
			Assert.assertTrue("The array of ints cannot contain any 1's and 3's. Expected true.",
					actualResult);
		
		}
	
	@Test
	public void one_and_three() {
		Lucky13 lucky = new Lucky13();
			int[] expectedArray = {1, 2, 3};
			boolean expectedResult = false;
			
			boolean actualResult = lucky.getLucky(expectedArray);
			
			Assert.assertFalse("The array of ints contained 1's and 3's. Expected false.",
					actualResult);
		
		}
	
	@Test
	public void only_one() {
		Lucky13 lucky = new Lucky13();
			int[] expectedArray = {1, 2, 4};
			boolean expectedResult = false;
			
			boolean actualResult = lucky.getLucky(expectedArray);
			
			Assert.assertFalse("The array of ints contained 1's. Expected false.",
					actualResult);
		
		}
	
	@Test
	public void array_not_null() {
		Lucky13 lucky = new Lucky13();
			int[] expectedArray = null;
			boolean expectedResult = false;
			
			boolean actualResult = lucky.getLucky(expectedArray);
			
			Assert.assertNotNull("The array of ints cannot be null. Expected false.",
					actualResult);
		
		}
	
	}


