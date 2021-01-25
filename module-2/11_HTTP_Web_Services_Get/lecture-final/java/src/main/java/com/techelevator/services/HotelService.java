package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;
    }

    public Hotel[] listHotels() {
    	String requestUrl = API_BASE_URL + "hotels";
    	return restTemplate.getForObject(requestUrl, Hotel[].class);
    }
    

    public Review[] listReviews() {
        return restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    public Hotel getHotelById(int id) {
    	String requestUrl = API_BASE_URL + "hotels/" + id;
        return restTemplate.getForObject(requestUrl, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
    	// ? is called a query string
    	// they are formatted like this
    	// ?key=value&key1=value1&key2=value2
    	String requestUrl = API_BASE_URL + "hotels?stars=" + stars;
        return restTemplate.getForObject(requestUrl, Hotel[].class);
    }

    public City getWithCustomQuery(){
        return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
    }

}
