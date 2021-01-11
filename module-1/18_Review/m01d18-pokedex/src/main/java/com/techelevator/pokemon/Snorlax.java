package com.techelevator.pokemon;

public class Snorlax extends Pokemon{
	private static final int INDEX = 143; //unit test bait
	
	@Override
	public String getName() {
		return "Snorlax";
	}
	
	public Snorlax() {
		super(INDEX, 110, 87);
	}
}
