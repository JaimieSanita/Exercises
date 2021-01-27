package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	private AuctionDAO dao;

	public AuctionController() {
		this.dao = new MemoryAuctionDAO();
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam (required = false, defaultValue = "") String title_like, @RequestParam (required = false, defaultValue = "0.00") double currentBid_lte) {
    	if(title_like != null && currentBid_lte > 0) {
    		return dao.searchByTitleAndPrice(title_like, currentBid_lte);
    	}
    	if(currentBid_lte > 0) {
    		return dao.searchByPrice(currentBid_lte);
    	}
    	if(title_like != null) {
    		return dao.searchByTitle(title_like);
    	}
    	return dao.list();
	}
	

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Auction get(@PathVariable int id) {
		return this.dao.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Auction create(@RequestBody Auction auction) {
		return this.dao.create(auction);
	}

}
