package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.asleep = false;
	}
	
	public abstract String eat() ;
	
	public void setIsAsleep(boolean isAsleep) {
		this.asleep = isAsleep;
	}

	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if( this.asleep) {
			return "Zzzzzzzzzzz.....";
		} else {
		return sound;
		}
	}

}