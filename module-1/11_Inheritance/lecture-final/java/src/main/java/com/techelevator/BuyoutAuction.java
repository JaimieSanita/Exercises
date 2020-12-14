package com.techelevator;

public class BuyoutAuction extends Auction {
	
	private int buyoutPrice;
	
	/**
	 * 
	 * @param itemForSale the description of the item for sale
	 * @param buyoutPrice the "buy it now price" 
	 */
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale);
		this.buyoutPrice = buyoutPrice;
	}

	public int getBuyoutPrice() {
		return buyoutPrice;
	}

	@Override
	public boolean placeBid(Bid offeredBid) {
		
		// if the bid is higher than or equal to the buyout
		// accept the bid at the buyout price
		// end the auction
		if(offeredBid.getBidAmount() >= this.getBuyoutPrice()) {
			Bid buyoutBid = new Bid(offeredBid.getBidder(), buyoutPrice);
			boolean boughtOut = super.placeBid(buyoutBid);
			if(boughtOut) {
				this.finishAuction();
				return true;
			}else {
				return boughtOut;
			}
			
		} else {
			// otherwise rely on the underlying placeBid behavior from the superclass
			return super.placeBid(offeredBid);
		}
		
	
		
	}
	
}
