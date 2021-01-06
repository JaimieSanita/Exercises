package com.techelevator.pokemon;

public abstract class Pokemon {
	
	protected static final int DEFAULT_MAX_HEALTH = 100;
	
	private int pokedexIndex;
	private int health;
	private int maxHealth;
	private int combatPower;

	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPokedexIndex() {
		return pokedexIndex;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getCombatPower() {
		return combatPower;
	}
	
	public abstract String getName();
	
	public Pokemon(int index, int maxHealth, int combatPower) {
		this.pokedexIndex = index;
		this.maxHealth = maxHealth;
		this.combatPower = combatPower;
		this.health = maxHealth;
	}
	
}
