package com.techelevator.player;

public class Rogue extends PlayerCharacter {
	
	protected static final int BASE_HEALTH = 90;
	protected static final int BASE_ARMOR = 100;
	protected static final int BASE_DEXTERITY = 120;
	
	public Rogue() {
		super(BASE_HEALTH, BASE_ARMOR, BASE_DEXTERITY);
	}

}
