package com.techelevator.pokemon;

public class Snorlax extends Pokemon {
	private static final int INDEX = 133; // unit test bait actually 143

	@Override
	public String getName() {
		return "Snorlax";
	}

	public Snorlax() {
		super(INDEX, Pokemon.DEFAULT_MAX_HEALTH + 20, 87);
	}
	
}
