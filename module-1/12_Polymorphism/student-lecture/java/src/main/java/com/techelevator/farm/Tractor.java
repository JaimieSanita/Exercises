package com.techelevator.farm;

public class Tractor implements Singable {

	@Override //used to indicate this method is coming in from somewhere else extended or implemented
	public String getName() {
		
		return "Tractor";
	}

	@Override
	public String getSound() {
		
		return "Vroom";
	}
	//tractor doesn't fit with FarmAnimal, inheritance doesn't make sense but tractor does 
	//use some of the protocols from FarmAnimal
	
	//create interface and extract what need for tractor implementation 
	
}
