package com.techelevator;

public class Elevator {
	
	//constant
	
	public static final int defaultLevel = 1;
	public static final int defaultFloor = 1;

	
	//instance variables
	
	private int currentFloor = defaultFloor;
	
	private int numberOfFloors;
	
	private boolean doorOpen;

	

	
	//getters
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	
	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	//constructor
	
	 public Elevator(int numberOfLevels) {
		numberOfLevels = getNumberOfFloors() - getCurrentFloor();
	
	}
	
	//methods
	
	public void openDoor() {
		if (!doorOpen) {
			this.doorOpen = true;
		}
	}
	
	public void closeDoor() {
		if (doorOpen) {
			this.doorOpen = true;
		}
	}
	
	public void goUp(int desiredFloor) {
		if(!isDoorOpen()) {
			if (desiredFloor <= numberOfFloors) {
			this.currentFloor = desiredFloor;
			}
		}
	}
	
	public void goDown(int desiredFloor) {
		if(!isDoorOpen()) {
			if (desiredFloor >= 1) {
				this.currentFloor = desiredFloor;
			}
		}
	}
	

}
