package com.techelevator;

public class SecondPriceAuction extends ReserveAuction {

	public SecondPriceAuction(String itemForSale, int reservePrice) {
		super(itemForSale, reservePrice);
	}

	@Override
	public Bid getWinningBid() {
		if (!this.isClosed()) {
			return super.getWinningBid();
		}

		// find the second price
		Bid secondPrice = null;

		// summary - find the second largest item in the bid list

		// for each Bid (called bid) in this.getAllBids (List<Bid>)
		for (Bid bid : this.getAllBids()) {

			// first check if this amount is actually smaller than the
			// highest bid
			if (bid.getBidAmount() < this.getHighBid().getBidAmount()) {
				// if we don't have a second bid, this is it by default
				if (secondPrice == null) {
					secondPrice = bid;
					// otherwise, if this is larger than our current candidate
					// but still smaller than the highest bid, this is our new
					// second price candidate
				} else if (bid.getBidAmount() > secondPrice.getBidAmount()) {
					secondPrice = bid;
				}
			}
		}

		// take the highest bid.
		// if there is more than one bid, the highest bidder pays the second price

		if (secondPrice == null) {
			return this.getHighBid();
		} else {
			// make a winning bid
			int newPrice = secondPrice.getBidAmount() + 1;
			String winningBidder = this.getHighBid().getBidder();
			return new Bid(winningBidder, newPrice);
		}
	}

}
