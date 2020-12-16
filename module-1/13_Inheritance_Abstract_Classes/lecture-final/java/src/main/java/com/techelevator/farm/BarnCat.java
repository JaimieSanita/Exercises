package com.techelevator.farm;

public final class BarnCat extends FarmAnimal {

	private static final String sound = "Meeeeooooow";
	
	public BarnCat() {
		super("Cat", sound);
	}
	
	// we can't have this
	// because getSound is final
	/*
	@Override
	public String getSound() {
		return sound;
	}
	*/

	@Override
	public String eat() {
		return "Catch a tasty mouse";
	}

	
	
}
