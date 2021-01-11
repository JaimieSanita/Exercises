package com.techelevator.pokemon;

public class Bulbasaur extends Pokemon {
	private static final int INDEX = 1;
	
	@Override
	public String getName() {
		return "Starter Pokemon #1.";
	}
	
	public Bulbasaur() {
		super(INDEX, 55, 28);
	}
}
