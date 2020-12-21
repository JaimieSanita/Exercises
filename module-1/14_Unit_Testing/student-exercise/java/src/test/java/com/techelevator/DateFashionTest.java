package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class DateFashionTest {

	// you (5), date (10) should return 2
	// you (5), date (2) should return 0
	// you (5), date (5) should return 1
	// you(-5), date (10) should return 0

	@Test
	public void get_a_table() {
		DateFashion table = new DateFashion();
		int expectedYou = 5;
		int expectedDate = 10;
		int expectedResult = 2;

		int actualResult = table.getATable(expectedYou, expectedDate);

		Assert.assertEquals("You and your date GET a table at the restaurant.", expectedResult, actualResult);

	}
	
	@Test
	public void no_table_for_you() {
		DateFashion table = new DateFashion();
		int expectedYou = 5;
		int expectedDate = 2;
		int expectedResult = 0;

		int actualResult = table.getATable(expectedYou, expectedDate);

		Assert.assertEquals("You and your date should NOT get a table at the restaurant.", expectedResult, actualResult);

	}
	
	@Test
	public void perchance_get_a_table() {
		DateFashion table = new DateFashion();
		int expectedYou = 5;
		int expectedDate = 5;
		int expectedResult = 1;

		int actualResult = table.getATable(expectedYou, expectedDate);

		Assert.assertEquals("You and your date MAY get a table at the restaurant.", expectedResult, actualResult);

	}
	
	@Test
	public void no_table_for_negative_style() {
		DateFashion table = new DateFashion();
		int expectedYou = -5;
		int expectedDate = 10;
		int expectedResult = 0;

		int actualResult = table.getATable(expectedYou, expectedDate);

		Assert.assertEquals("You and your date should NOT get a table at the restaurant.", expectedResult, actualResult);

	}
	
}
