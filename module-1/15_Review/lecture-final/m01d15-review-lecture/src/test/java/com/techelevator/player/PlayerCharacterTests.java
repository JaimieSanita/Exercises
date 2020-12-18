package com.techelevator.player;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


public class PlayerCharacterTests {

	private PlayerCharacter character;
	
	@Before
	public void setup() {
		character = new Rogue();
	}
	
	@After
	public void teardown() {
		character = null;
	}
	
	@Test
	public void initialHealthCorrect() {
		// Arrange
		// ** handled by the before in this case
		
		// Act
		
		int actualHealth = character.getHealth();
		
		// Assert
		Assert.assertEquals("Health should match initial value",
				Rogue.BASE_HEALTH, 
				actualHealth);
	}
	
	@Test
	public void initialMaxHealthCorrect() {
		// Arrange
		// ** handled by before
		
		// Act
		
		int actual = character.getMaxHealth();
		
		Assert.assertEquals("Max health should match default value",
				Rogue.BASE_HEALTH,
				actual);
	}
	
	@Test
	public void initialDexterity() {
		// Arrange
		// ** handled by before
		
		int actual = character.getDexterity();
		
		Assert.assertEquals("Initial dexterity should match",
				Rogue.BASE_DEXTERITY, 
				actual);
	}

	
	@Test
	public void basicDamageTest() {
		// Arrange
		// note the character is created above in the @Before
		// need to make sure I actually damage the character
		int expectedDifference = 10;
		int amountOfDamageToApply = character.getAmor() + expectedDifference;
		int initialHealth = character.getHealth();
		
		//Act
		// apply the damage to the character
		character.takeDamage(amountOfDamageToApply);
		// the players health after they take damage
		int adjustedHealth = character.getHealth();
		// the net difference between the players initial health, and their health after taking damage
		int actualDamage = initialHealth - adjustedHealth;
		
		// Assert
		Assert.assertTrue("Health should change when taking damage", initialHealth != adjustedHealth);
		Assert.assertEquals("Damage value should have been removed from health",expectedDifference, actualDamage);
		
	}
	
}
