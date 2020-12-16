package com.techelevator.farm;


//all FarmAnimals will have asleep functions because on base class
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.asleep = false;
	}
	//abstract METHOD; must be in abstract class
	//must now be OVERRIDDEN by subclasses
	//there no body, definition of performance
	//can have different performance on different FarmAnimals
	public abstract String eat();

	public String getName( ) {
		return name;
	}
	
	//marked method as final means you can no longer Override this method
	public final String getSound( ) {
		if(this.asleep) {
			return "Zzzzzzzz....";
		} else {
		return sound;
	}
	}
	
	public void setisAsleep(boolean isAsleep) {
		this.asleep = isAsleep;
	}

}