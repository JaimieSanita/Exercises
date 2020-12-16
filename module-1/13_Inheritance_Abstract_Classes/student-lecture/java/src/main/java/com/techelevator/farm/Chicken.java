package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	//Override due to abstract method
	//this method will behavior
	//can NOT have abstract keyword, because needs to implement behavior
	//Overriding an abstract method works exactly like overriding concrete method
	//Cannot use super keyword because no implementation of super from abstract class
	@Override
	public String eat() {
		return "Peck at some worms on the ground...";
	}

}