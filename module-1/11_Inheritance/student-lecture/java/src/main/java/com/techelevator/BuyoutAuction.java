package com.techelevator;

public class BuyoutAuction extends Auction {

	private int buyoutPrice;

	// constructor
	// buy it now price new to this constructor
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale);
		this.buyoutPrice = buyoutPrice;

	}

	// getter
	public int getBuyoutPrice() {
		return buyoutPrice;
	}

	@Override
	public boolean placeBid(Bid offeredBid) {
		// if bid >= buyoutPrice
		// accept bid at buyout price
		// end auction
		// otherwise depend on underplaying placeBid behavior from superclass
		
		if (offeredBid.getBidAmount() >= getBuyoutPrice()) {
			// create new bid for buyout
			Bid buyoutBid = new Bid(offeredBid.getBidder(), buyoutPrice);
			boolean boughtOut = super.placeBid(buyoutBid);
			if (boughtOut) {
				// finishAuction method inherited from Auction
				this.finishAuction();
				return true;
			} else {
				return boughtOut;
			}
		} else {
			return super.placeBid(offeredBid);
		}
	}
}
