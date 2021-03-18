package com.techelevator.apocalypse_now.models;

public class Status {
	private boolean apocalypse;
	private String message;
	
	
	public boolean isApocalypse() {
		return apocalypse;
	}
	public void setApocalypse(boolean apocalypse) {
		this.apocalypse = apocalypse;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
