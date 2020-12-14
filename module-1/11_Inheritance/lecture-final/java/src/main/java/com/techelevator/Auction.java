package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private Bid defaultBid = new Bid("PLACEHOLDER",0);
	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;
	private boolean closed;

	/**
	 * Constructors
	 * @param itemForSale
	 */
	
	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = defaultBid;
		allBids = new ArrayList<>();
		this.closed = false;
	}

	/**
	 * 
	 * Methods
	 * 
	 */
	
	public boolean placeBid(Bid offeredBid) {
		
		// if the auction is closed
		// return false
		if(this.isClosed()) {
			return false;
		}
		
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}
	
	public boolean finishAuction() {
		if(this.isClosed()) {
			return false;
		}else {
			this.closed = true;
			return true;
		}
	}


	/** 
	 * Getters and Setters
	 * 
	 */
	
	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}
	
	public boolean isClosed() {
		return this.closed;
	}
	
	public Bid getWinningBid() {
		if(this.isClosed()) {
			return this.getHighBid();
		} else {
			// You should think hard before doing
			// this. We're relying on the caller
			// checking isClosed before they use
			// this variable
			//return null;
			
			//alternatively return a default
			return defaultBid;
		}
	}
	
	public String getItemForSale() {
		return itemForSale;
	}
	
	
}
