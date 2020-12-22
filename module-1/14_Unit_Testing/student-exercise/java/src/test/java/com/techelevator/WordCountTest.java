package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class WordCountTest {
	
	// * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 } *
	// * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}*
	// * getCount([]) → {}*
	// * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}*
	
	@Test
	public void get_count_works_baba() {
		WordCount test = new WordCount();
		String[] expectedArray = {"ba", "ba", "black", "sheep"};
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("ba", 2); 
		expectedResult.put("black", 1); 
		expectedResult.put("sheep", 1); 
		
		Map<String, Integer> actualResult = test.getCount(expectedArray);
		
		Assert.assertEquals("Expected ba : 2, black : 1, sheep : 1.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void get_count_works_abc() {
		WordCount test = new WordCount();
		String[] expectedArray = {"a", "b", "a", "c", "b"};
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("a", 2); 
		expectedResult.put("b", 2); 
		expectedResult.put("c", 1); 
		
		Map<String, Integer> actualResult = test.getCount(expectedArray);
		
		Assert.assertEquals("Expected a: 2, b: 2, c: 1.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void get_count_works_empty() {
		WordCount test = new WordCount();
		String[] expectedArray = {""};
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("", 0); 
		
		Map<String, Integer> actualResult = test.getCount(expectedArray);
		
		Assert.assertEquals("If the array is empty, expected return of empty string key with value 0.)",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void get_count_works_cba() {
		WordCount test = new WordCount();
		String[] expectedArray = {"c", "b", "a"};
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("c", 1); 
		expectedResult.put("b", 1); 
		expectedResult.put("a", 1); 
		
		Map<String, Integer> actualResult = test.getCount(expectedArray);
		
		Assert.assertEquals("Expected c: 1, b: 1, a: 1.",
				expectedResult, 
				actualResult);
	}
	
	@Test
	public void get_count_works_null() {
		WordCount test = new WordCount();
		String[] expectedArray = null;
		Map<String, Integer> expectedResult = new HashMap<>();
		
		Map<String, Integer> actualResult = test.getCount(expectedArray);
		
		Assert.assertNotNull("String array cannot be null", actualResult);
		Assert.assertEquals("If the string array is null, return the Dictionary.",
				expectedResult, 
				actualResult);
	}
	

}
