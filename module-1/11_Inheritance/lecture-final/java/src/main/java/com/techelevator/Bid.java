package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}

	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}
	
	/**
	 * This is a really useful construct to do in your own classes
	 * 
	 * Think about defining logical toString implementations that
	 * give you useful information for debugging
	 */
	
	@Override
	public String toString() {
		return "Bidder: " + this.getBidder() + " Bid Amount: $" + this.getBidAmount();
	}
	
}
