package com.techelevator.exceptions;

public class OverdraftException extends Exception { //create OverdraftException because extends from general built-in Exception class

	private double overdraftAmount = 0;
	
	public OverdraftException(String message, double overdraftAmount) { //takes message & double over by
		super(message);													//calling super constructor for message
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
