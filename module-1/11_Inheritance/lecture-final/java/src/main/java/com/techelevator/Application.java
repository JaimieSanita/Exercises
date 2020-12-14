package com.techelevator;

import java.util.List;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        
        //    this line is an example of polymorphism
        //    the variable is type Auction - the type used was ReserveAuction
              
        Auction reserveAuction = new ReserveAuction("Shelby Mustang - Elenore",20000);
       
        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(reserveAuction);
        auctions.add(new SecondPriceAuction("Shelby Mustang - Elenore II", 20000));
        auctions.add(new BuyoutAuction("Shelby Mustang - Elenore III", 20000));
        
        
        // for each Auction (called auction) in our List<Auction> (auctions)
        for(Auction auction : auctions) {
        	auction.placeBid(new Bid("Andrew",15000));
        	auction.placeBid(new Bid("Bobby", 25000));
        	auction.placeBid(new Bid("Mike", 27000));
        	auction.finishAuction();
        	System.out.println(auction.getWinningBid());
        }
        
        
    }
}
