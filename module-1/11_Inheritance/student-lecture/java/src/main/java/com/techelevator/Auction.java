package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {
	
	//instance variables

	private Bid defaultBid = new Bid("PLACEHOLDER", 0);
	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;
	private boolean closed;
	
	//constrcutor

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = defaultBid;
		allBids = new ArrayList<>();
		this.closed = false;
	}

	//methods
	
	public boolean placeBid(Bid offeredBid) {
		
		//if auction is closed, return false
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
		} else {
			this.closed = true;
			return true;
		}
	}
	
	//getters & setters

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
		//if auction closed, get high bid
		if(this.isClosed()) {
			return this.getHighBid();
		} else {
			//think hard before setting to null;
			//b/c relying on caller to check isClosed
			//before they use this variable
			//return null;
			
			//alternate return defaultBid
			return defaultBid;
		}
	}
	
	public String getItemForSale() {
		return itemForSale;
	}
}
