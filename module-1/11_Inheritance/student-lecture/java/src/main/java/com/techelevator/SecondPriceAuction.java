package com.techelevator;

public class SecondPriceAuction extends ReserveAuction {

	public SecondPriceAuction(String itemForSale, int reservePrice) {
		super(itemForSale, reservePrice);
	}

	@Override
	public Bid getWinningBid() {
		// Summary: find second largest item in the bid list

		// thing i have:
		// 1.high bidder 2. list of bids
		if (!this.isClosed()) {
			// auction closed, no second price
			return super.getWinningBid();
		}
		// find second price
		// set variable to hold secondprice
		Bid secondPrice = null;
		for (Bid bid : this.getAllBids()) {
			// check bid amount is smaller than highest bid
			if (bid.getBidAmount() < this.getHighBid().getBidAmount()) {
				// if secondPrice = null or doesn't exist, then this is default
				if (secondPrice == null) {
					secondPrice = bid;
					// if this is larger than current candidate, but still
					// smaller, than the hightest bid, this is new
					// second price candidate
				} else if (bid.getBidAmount() > secondPrice.getBidAmount()) {
					secondPrice = bid;
				}
			}
		}

		// take highest bid
		// if there is more than one bid, highest bidder pays second price

		if (secondPrice == null) {
			return this.getHighBid();
		} else {
			// make winning bid
			int newPrice = secondPrice.getBidAmount() + 1;
			String winningBidder = this.getHighBid().getBidder();
			return new Bid(winningBidder, newPrice);
		}

	}
}
