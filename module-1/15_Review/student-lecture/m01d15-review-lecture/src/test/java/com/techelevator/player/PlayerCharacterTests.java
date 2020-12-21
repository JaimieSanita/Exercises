package com.techelevator.player;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class PlayerCharacterTests {

	private PlayerCharacter character; //created PlayerCharacter class called character
	
	@Before //run this before running test; create Rogue character before test
	public void setup() {
		character = new Rogue();
		//need a character to test a character
	}
	
	@Test
	public void intialHealthCorrect() {
		//ARRANGE
		//HANDLED BY THE BEFORE test
		
		//ACT
		int actualHealth = character.getHealth();
		//ASSERT
		Assert.assertEquals("Health should match initial value",
				Rogue.BASE_HEALTH, //expected
				actualHealth);		//testvalue
	}
	
	@After //delete character 
	public void teardown() {
		character = null;
	}
	
	@Test
	public void initialMaxHealthCorrect() {
		//arrange;handled by before
		
		//act
		int actual = character.getMaxHealth();
		
		//assert
		Assert.assertEquals("Max health should match default value",
				Rogue.BASE_HEALTH,
				actual);
		
		
	}
	
	@Test
	public void initialDexterityCorrect() {
		//arrange; handled by Before
		
		//act
		int actual = character.getDexterity();
		
		//assert
		Assert.assertEquals("Dexterity should match default value",
				Rogue.BASE_DEXTERITY,
				actual);
	}
	
	@Test//happy path
	public void basicDamageTest() {
		//ARRANGE; character created in @Before test
		//need to make sure I actually damage the character, so choose 10 to ensure damaged
		int expectedDifference = 10;
		int damageValue = character.getArmor() + expectedDifference;
		//need health before damage
		int initialHealth = character.getHealth(); 
		
		//ACT
		//call take damage method and checking damageValue
		//apply damage to character
		character.takeDamage(damageValue);
		//check health to see if damaged
		//players health after they take damage
		int adjustedHealth = character.getHealth();
		//actual calculation
		//net dif b/w players intial health and their health after taking damage
		int actualDamage = initialHealth - adjustedHealth;
		
		//ASSERT
		Assert.assertTrue("Health should chenge when taking damage",
				initialHealth != adjustedHealth);
		Assert.assertEquals("Damage value should have been removed from health",
				expectedDifference,
				actualDamage);
	}
	
	
	}

