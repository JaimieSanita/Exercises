package com.techelevator.pokemon;

public class Rapidash extends Pokemon {
	private static final int INDEX = 78;
	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public Rapidash(String name) {
		super(INDEX, Pokemon.DEFAULT_MAX_HEALTH, 77);
		this.name = name;
	}
}
