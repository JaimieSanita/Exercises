package com.techelevator.model;

public class Exercise {

	private long id;
	private String name;
	
	public Exercise(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
