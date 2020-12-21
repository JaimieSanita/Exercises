package com.techelevator.player;

public class Rogue extends PlayerCharacter{
	
	protected static final int BASE_HEALTH = 90;
	protected static final int BASE_ARMOR = 100;
	protected static final int BASE_DEXTERITY = 120;
	//final on variable means these values cannot change; that's why variables are named Base etc.
	//final on class means you can not inherit from it
	
	//protected allows visibility within same package but not global
	
	public Rogue() {
		super(BASE_HEALTH, BASE_ARMOR, BASE_DEXTERITY);
	}

}
