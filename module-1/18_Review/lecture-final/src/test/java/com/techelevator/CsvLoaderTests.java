package com.techelevator;

import java.io.File;
import java.util.Map;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.pokemon.Pokemon;

public class CsvLoaderTests {

	private CsvLoader loader;
	
	// We can use the before method to setup our test CsvLoader
	@Before
	public void Setup(){
		loader = new CsvLoader(new File("test_pokedex.csv"));
	}
	
	@Test
	public void convertLineWorksInHappyPath() {
		String testLine = "Snorlax, sleepy";
		Pokemon p = loader.convertLineIntoPokemon(testLine);
		
		//we should get a valid pokemon with snorlax as a name back
		Assert.assertNotNull("Our pokemon shouldn't be null",p);
		Assert.assertEquals("Should have a snorlax", "Snorlax",p.getName());
	}
	
	@Test
	public void convertLineNullShouldReturnNull() {
		String testLine = null;
		Pokemon p  = loader.convertLineIntoPokemon(testLine);
		
		Assert.assertNull("If we give a null string we should get a null pokemon back",p);
		
	}
	
	@Test
	public void convertLineShouldGiveNullWithMissingValues() {
		String testLine = "Snorlax"; // no , and second name, should fail
		Pokemon p = loader.convertLineIntoPokemon(testLine);
		Assert.assertNull("Should get null with our CSV is missing values", p);
	}
	
	@Test
	public void loadHappyPath() {
		Map<Integer,Pokemon> pokedex = loader.loadPokedex();
		Assert.assertEquals("Our pokedex should have 3 entries", 3, pokedex.size());
	}
}
