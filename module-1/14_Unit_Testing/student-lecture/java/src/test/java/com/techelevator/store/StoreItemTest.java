package com.techelevator.store;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.math.BigDecimal;

				//sorts methods by name alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StoreItemTest {
	
	//test getters
	@Test //must have this @Test annotation or won't read as test
	public void testName() {
		
		//Arrange
		//String set to constant value
		String expectedName = "Idle Name";
		//Must create StoreItem; copy of StoreItem class and giving constructor expectedName and default additional arguments
		//once 							//constructor arguments
										//String			//Price					//Quantity
										//only checking name	//value doesn't matter	//value doesn't matter
		StoreItem item = new StoreItem(expectedName, 		BigDecimal.ZERO,		 0);
		
		//Act
		//call getter method
		String actualName = item.getName();
		
		//Assert
		Assert.assertEquals("The name provided to constructor should come back from the getter", 
				expectedName, 
				actualName);
	}
	
	@Test
	public void NullPrice() {
		
		//ARRANGE(price, storeItem)
		//								 //null price in constructor
		StoreItem item = new StoreItem("", null, 0);
		
		
		//ACT
		
		BigDecimal actualPrice = item.getPrice();
		
		//ASSERT
		
		Assert.assertNotNull("Price should never be null on an item", actualPrice);
		//test that if price null, set price equal to 0
		Assert.assertEquals("If given null, use 0 for the price",
				BigDecimal.ZERO,
				actualPrice);
		
	}
	//happy path test, basic test 
	@Test
	public void GetQuantity() {
		//ARRANGE
		int expectedQuantity = 7;
		//have to construct the object to test the object in ACT phase
		StoreItem item = new StoreItem("", BigDecimal.ZERO, expectedQuantity);
		//ACT
		int actualQuantity = item.getQuantity();
		//ASSERT
		Assert.assertEquals("The quantity provided to constructor should come from getter ",
				expectedQuantity, //expected
				actualQuantity); //actual
	}
	
	@Test
	public void noNegativeQuantities() {
		
		//ARRANGE
		int providedQuantity = -7;	//this is the quantity we're passing in to test constructor
		int expectedQuantity = 0; //quantity not in stock
		
		StoreItem item = new StoreItem("", BigDecimal.ZERO, providedQuantity);
		
		//ACT
		int actualQuantity = item.getQuantity();
		
		//ASSERT
		Assert.assertEquals("Negative quantities become zero.",
				expectedQuantity, 
				actualQuantity);
		
	}
	//happy path
	@Test
	public void simpleTotalWorks() {
		
		//ARRANGE; pick obvious numbers
		int quantity = 2;
		BigDecimal price = new BigDecimal(5);
		BigDecimal expectedTotal = new BigDecimal(10);
		
		StoreItem item = new StoreItem("", price, quantity);
		
		//ACT
		BigDecimal total = item.getTotal();
		//ASSERT
		Assert.assertEquals("Total should be quantity x price",
				expectedTotal,
				total);
		
	}

}
