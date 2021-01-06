package com.techelevator.pokemon;

public class Eevee extends Pokemon {
	private static final int INDEX = 133;
	
	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public Eevee(String name) {
		super(INDEX, Pokemon.DEFAULT_MAX_HEALTH, 80 );
		this.name = name;
	}
}
