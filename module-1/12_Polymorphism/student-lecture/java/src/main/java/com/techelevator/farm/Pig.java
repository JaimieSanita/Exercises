package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable {
	//empty constructor but calling
	public Pig() {
		super("Pig", "Oink");
	}
	
	public String makeBacon() {
		return "Delicious Bacon";
	}

	@Override
	public BigDecimal getPrice() {
		
		return new BigDecimal(250);
	}

	@Override
	public String getMeal() {
		
		return makeBacon();
	}
}
