package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal implements Sellable {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public Egg layEgg() {
		System.out.println("Chicken laid an egg!");
		return new Egg();
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(5);
	}

	@Override
	public String getMeal() {
		return "Fried Chicken";
	}

}