package com.techelevator;
	//if no extends, then extends from Object
public class Bid {

	private String bidder; //defines person bidding
	private int bidAmount; //defines amount of bid

	//constructor
	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}
	//getters 
	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}
	
	
	/*
	 * 
	 * This is a really useful construct to do in your own classes
	 * 
	 * think about defining logical toString implementations that
	 * give you useful information for debugging
	 * 
	 * 
	 */
	
	//toString() comes from object class
	//every object in java has toString() method
	//
	@Override
	public String toString() {
		return "Bidder: " + this.getBidder() + "Bid Amount: $" + this.getBidAmount();
	}
}
