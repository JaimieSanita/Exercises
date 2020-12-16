package com.techelevator.farm;


//final means this class can't be inherited
public final class BarnCat extends FarmAnimal {
	
	//FarmAnimal implements Singable so Singable is inherited by BarnCat
	private static final String sound = "Meeeoooowwww";

	public BarnCat() {
		super("Cat", sound);
	}

	/*
	 * we cant have this Override because getSound is final on FarmAnimal class
	
	@Override
	public String getSound() {
		return sound;
	}
	/*
	 * 
	 */
	@Override
	public String eat() {
		
		return "Catch a tasty mouse";
	}

}
