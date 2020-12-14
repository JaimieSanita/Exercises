package com.techelevator;

/**
 * 
 * @author Student
 *
 *
 *This class models an auction in which the bidder has to pay a minimum
 * amount to have their bid accepted, this amount is set in advance and is
 * called the `reserve` price. If the auction does not reach that amount
 * the item remains unsold
 */

//              this class   inherits   from this 
public class ReserveAuction   extends     Auction {
	
	private int reservePrice;
	
	public ReserveAuction(String itemForSale, int reservePrice) {
		super(itemForSale);

		this.reservePrice = reservePrice;		
	}
	
	/*
	 * This class overrides the default bid method
	 * it checks the provided bid against the reserve price and only accepts
	 * the bid if the reserve price is met
	 */
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		if(offeredBid.getBidAmount() >= this.reservePrice) {
			isCurrentWinningBid = super.placeBid(offeredBid);
		}
		return isCurrentWinningBid;
	}
	
	
	
	
	
	
	
	
	

}
