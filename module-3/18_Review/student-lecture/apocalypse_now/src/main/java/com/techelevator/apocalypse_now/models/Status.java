package com.techelevator.apocalypse_now.models;

public class Status {
	
	private boolean apocalyse;
	private String message;
	
	public boolean isApocalyse() {
		return apocalyse;
	}
	public void setApocalyse(boolean apocalyse) {
		this.apocalyse = apocalyse;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
