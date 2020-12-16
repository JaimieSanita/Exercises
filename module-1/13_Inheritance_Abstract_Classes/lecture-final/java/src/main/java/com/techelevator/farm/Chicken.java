package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	private boolean rooster;
	
	public Chicken(String name, String sound, boolean isRooster) {
		super(name,sound);
		this.rooster = isRooster;
	}
	
	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	
	// Note that overriding an abstract method works exactly the same
	// as overriding a regular method. You can't use the super keyword though
	@Override
	public String eat() {
		return "Peck at some worms on the ground...";
	}

}