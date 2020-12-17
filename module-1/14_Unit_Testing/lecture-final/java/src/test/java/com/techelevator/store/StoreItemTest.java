package com.techelevator.store;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreItemTest {
	
	@Test
	public void testName() {
		// Arrange
		
		String expectedName = "Idle Name";
		
		
		StoreItem item = new StoreItem(expectedName, BigDecimal.ZERO, 0);
		
		// Act
		String actualName = item.getName(); 
		
		// Assert
		

		Assert.assertEquals(
				"The name provided to the constructor should be available in the getter", 
				expectedName, 
				actualName);
	}
	
	@Test
	public void NullPrice() {
		// Arrange
		StoreItem item = new StoreItem("", null, 0);
		
		//Act
		
		BigDecimal actualPrice = item.getPrice();
		
		//Assert
		
		Assert.assertNotNull("Price should never be null on an item", actualPrice);
		Assert.assertEquals(
				"If given null, use 0 for the price",
				BigDecimal.ZERO,
				actualPrice);
	}
	
	@Test
	public void getQuantity() {
		
		// Arrange
		int expectedQuantity = 7;
		
		StoreItem someItem = new StoreItem("", BigDecimal.ZERO, expectedQuantity);
		
		// Act
		
		int actual = someItem.getQuantity();
		
		// Assert
		
		Assert.assertEquals("Expect the constructor quantity to be in the getter",
				expectedQuantity,
				actual);
		
	}
	
	@Test
	public void noNegativeQuantities() {
		
		// Arrange
		int providedQuantity = -7;
		int expectedQuantity = 0;
		
		StoreItem anItem = new StoreItem("", BigDecimal.ZERO, providedQuantity);
		
		// Act
		
		int actualQuantity = anItem.getQuantity();
		
		//Assert
		Assert.assertEquals("Negative quantities should become 0",
				expectedQuantity,
				actualQuantity);
		
	}
	
	@Test
	public void simpleTotalWorks() {
		// Arrange
		int quantity = 2;
		BigDecimal price = new BigDecimal(5);
		BigDecimal expectedTotal = new BigDecimal(10);
		
		StoreItem item = new StoreItem("", price, quantity);
		
		//Act
		
		BigDecimal total = item.getTotal();
		
		
		// Assert
		
		Assert.assertEquals("Total should be quantity x price",
				expectedTotal,
				total);
	}
	
}
