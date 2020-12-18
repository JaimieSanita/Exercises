package com.techelevator.player;

import com.techelevator.Battleable;

public abstract class PlayerCharacter implements Battleable {
	
	private int health;
	private int maxHealth;
	private int baseArmor;
	private int dexterity;
	
	public PlayerCharacter(int maxHealth, int baseArmor, int dexterity) {
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.baseArmor = baseArmor;
		this.dexterity = dexterity;
	}

	@Override
	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getDexterity() {
		return dexterity;
	}
	
	public int getAmor() {
		return this.baseArmor;
	}
	
	@Override
	public void takeDamage(int damageAmount) {
		
		// first calculate the damage absorbed by our armor
		
		// variable assign.        condition              ?    if true                    : if false
		int netDamage =     damageAmount > this.getAmor() ? damageAmount - this.getAmor() :     0;
		
		if(netDamage > this.getHealth()) {
			this.health = 0;
		} else {
			this.health = this.getHealth() - netDamage;
					
		}
	}

}
