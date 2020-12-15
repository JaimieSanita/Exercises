package com.techelevator.farm;

public interface Singable {

	//interface are protocol, therefore all methods are PUBLIC. no need for access modifier
	//no body to these getters
	//interfaces do not define the body or how it behaves
	//interfaces define where not how
	//no constructor because interfaces require class to function; class must implement interface
		
	String getName();
	String getSound();
	
	
}
