package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate; //if API conforms to RestTemplate can do .class translation

public class HotelService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate(); //abstraction that covers HTTP; just need to know URL & what to convert it into

    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;
    }

    public Hotel[] listHotels() {								//take this blueprint & you construct it Java
    															//get the data from this location & put it in a Hotel object array
        return restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class); 
    }

    public Review[] listReviews() { //different way to format from above; this is preferred
    	String requestURL = API_BASE_URL + "reviews";
    									//URL		//format
        return restTemplate.getForObject(requestURL, Review[].class);
    }

    public Hotel getHotelById(int id) {
    	String requestURL = API_BASE_URL + "hotels/" + id;
        return restTemplate.getForObject(requestURL, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
    	// ? is called a query string
    	//formatted like this:
    	//?key=value&key1=value1&key2=value2
    	String requestURL = API_BASE_URL + "hotels?stars=" + stars;
        return restTemplate.getForObject(requestURL, Hotel[].class);
    }

    public City getWithCustomQuery(){
        return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
    }

}
