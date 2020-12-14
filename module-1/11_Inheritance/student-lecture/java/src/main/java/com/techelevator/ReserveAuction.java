package com.techelevator;


/**
 * 
 * @author Student
 * 
 * this class models an auction in which the bidder has to pay a 
 * minimum amount to have their bid accepted
 * 
 * the amount is set in advance 
 * called the "reserve" price
 * 
 * if auction does not reach that amount, item remains unsold
 *
 */

			//this class inherits from Auction
public class ReserveAuction extends Auction {
	
	private int reservePrice;
						//from parent constructor
	public ReserveAuction(String itemForSale, int reservePrice) {
		//super keyword refers to anything on parent class
		//can only use super with extends
		//super is calling constructor on parent class 
		super (itemForSale);
		this.reservePrice = reservePrice;
	}
	
	/**
	 * 
	 * this class overrides the default bid method
	 * it checks the provided bid against the reserve price and 
	 * only accepts bid if the reserve price is met
	 * 
	 */
	//name and aruguments must match to override because subbing in 
	//sharing functionality of placeBid method from Auction
	//Override allows replacement of old method with below method
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() >= this.reservePrice) {
			//					go call this method exactly
			//super refers to class extended from ie Auction
			isCurrentWinningBid = super.placeBid(offeredBid);
		}
		return isCurrentWinningBid;
	}
}



