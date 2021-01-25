package com.techelevator.services;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    public static final String BASE_URL = "http://localhost:3000/auctions";
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();


    public Auction[] listAllAuctions() {
        String requestURL = BASE_URL;
        return restTemplate.getForObject(requestURL, Auction[].class);
    }

    public Auction listDetailsForAuction(int id) {
        String requestURL = BASE_URL + "/"+ id;
        return restTemplate.getForObject(requestURL, Auction.class);
    }

    public Auction[] findAuctionsSearchTitle(String title) {
       String requestURL = BASE_URL + "?title_like=" + title;
        return restTemplate.getForObject(requestURL, Auction[].class);
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        String requestURL = BASE_URL + "?currentBid_lte=" + price;
        return restTemplate.getForObject(requestURL, Auction[].class);
    }

}
