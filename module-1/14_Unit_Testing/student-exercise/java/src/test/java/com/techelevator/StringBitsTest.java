package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;



public class StringBitsTest {
	
	// * GetBits("Hello") → "Hlo" *
	// * GetBits("Hi") → "H" *
	// * GetBits("Heeololeo") → "Hello"*
	//null *
	//empty*
	
	@Test
	public void string_bits_works_hello() {
		StringBits bits = new StringBits();
		String expectedString = "Hello";
		String expectedResult = "Hlo";
		
		String actualResult = bits.getBits(expectedString);
		
		Assert.assertEquals("Expected Hlo.", expectedResult, actualResult);
	}
	
	@Test
	public void string_bits_works_hi() {
		StringBits bits = new StringBits();
		String expectedString = "Hi";
		String expectedResult = "H";
		
		String actualResult = bits.getBits(expectedString);
		
		Assert.assertEquals("Expected H.", expectedResult, actualResult);
	}
	
	@Test
	public void string_bits_works_heeololeo() {
		StringBits bits = new StringBits();
		String expectedString = "Heeololeo";
		String expectedResult = "Hello";
		
		String actualResult = bits.getBits(expectedString);
		
		Assert.assertEquals("Expected Hello.", expectedResult, actualResult);
	}
	
	@Test
	public void string_bits_works_empty() {
		StringBits bits = new StringBits();
		String expectedString = "";
		String expectedResult = "";
		
		String actualResult = bits.getBits(expectedString);
		
		Assert.assertEquals("Given an empty string, an empty string is expected.", expectedResult, actualResult);
	}
	
	@Test
	public void string_bits_not_null() {
		StringBits bits = new StringBits();
		String expectedString = null;
		String expectedResult = "";
		
		String actualResult = bits.getBits(expectedString);
		Assert.assertNotNull("The string provided should not be null", actualResult);
		Assert.assertEquals("If the string provided is null, return an empty string.", expectedResult, actualResult);
	}
	
	@Test
	public void string_bits_works_1234() {
		StringBits bits = new StringBits();
		String expectedString = "1234";
		String expectedResult = "13";
		
		String actualResult = bits.getBits(expectedString);
		
		Assert.assertEquals("Expected 13. The string should return every other character beginning with first, even if numbers.", expectedResult, actualResult);
	}
	

}
