package com.techelevator.pokemon;

public abstract class Pokemon {
	//CONSTANTS
	protected static final int DEFAULT_MAX_HEALTH = 100;
	
	private int pokeDexIndex;
	private int health;
	private int maxHealth;
	private int combatPower;
	
	
	//GETTERS & SETTERS
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getPokeDexIndex() {
		return pokeDexIndex;
	}
	public int getHealth() {
		return health;
	}
	public int getCombatPower() {
		return combatPower;
	}
	
	public abstract String getName(); //abstract getters & says all subclasses need this getName() method
	
	//CONSTRUCTOR
	public Pokemon(int index, int maxHealth, int combatPower) {
		this.pokeDexIndex = index;
		this.maxHealth = maxHealth;
		this.combatPower = combatPower;
		this.health = health;
	}
	

	
	
}
