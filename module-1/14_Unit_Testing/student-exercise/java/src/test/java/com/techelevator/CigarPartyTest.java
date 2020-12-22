package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class CigarPartyTest {
	
	//happy path
	//int cigars 0*
	//int cigars -5*
	//boolean is weekend*
	//boolean is weekday*
	//boolean is weekday and cigars 1000*


	
	@Test//happy path
	public void cigar_test_works_weekend() {
		
		CigarParty copyOfClass = new CigarParty();
		int expectedCigar = 41;
		boolean weekend = true;
		
		boolean actualResult = copyOfClass.haveParty(expectedCigar, weekend);
		
		Assert.assertTrue("A squirrel party with 41 cigars on the weekend should be successful. Expeted true.",
				actualResult);
		
	}
	
	@Test
	public void cigar_test_works_weekday() {
		
		CigarParty copyOfClass = new CigarParty();
		int expectedCigar = 41;
		boolean weekend = false;
		
		boolean actualResult = copyOfClass.haveParty(expectedCigar, weekend);
		
		Assert.assertTrue("A squirrel party with 41 cigars on a weekeday should be successful. Expected true.",
				actualResult);
	
	}
	
	@Test
	public void too_few_cigars() {
		CigarParty copyOfClass = new CigarParty();
		int expectedCigar = 0;
		boolean weekend = true;
		
		boolean actualResult = copyOfClass.haveParty(expectedCigar, weekend);
		
		Assert.assertFalse("The cigar party should be unsuccessful with 0 cigars. Expected false.",
				actualResult);
	}
	
	@Test
	public void too_many_cigars() {
		CigarParty copyOfClass = new CigarParty();
		int expectedCigar = 1000;
		boolean weekend = false;
		
		boolean actualResult = copyOfClass.haveParty(expectedCigar, weekend);
		
		Assert.assertFalse("The cigar party should be unsuccessful with 1000 cigars on a weekday. Expected false.",
				actualResult);
	}
	
	@Test
	public void negative_cigars() {
		CigarParty copyOfClass = new CigarParty();
		int expectedCigar = -5;
		boolean weekend = true;
		
		boolean actualResult = copyOfClass.haveParty(expectedCigar, weekend);
		
		Assert.assertFalse("Cannot have negative cigars at a successful cigar party. Expected false.",
				actualResult);
	}
	

}
