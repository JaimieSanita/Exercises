package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String BASE_URL;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ConsoleService console; //instantiate inside constructor

  public HotelService(String url, ConsoleService console) {
    BASE_URL = url;
    this.console = console; //instantiated
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
	  
	  //convert String into reservation object
	  Reservation reservation = this.makeReservation(newReservation); //information from user but not include all info
	  if(reservation == null) {
		  return null; //if null, bump out & return null
	  }
	  //make API call to insert reservation object
	  HttpHeaders headers = new HttpHeaders(); //need header instance to define what is being set
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  			//create Reservation type of HttpEntity instance 			 //reservation instance //headers which tell format to turn into(JSON)									
	  HttpEntity<Reservation> entity 			= new HttpEntity<Reservation>(reservation,			headers); //entity is the request
	  					//http://localhost/hotels/1234/reservations
	  String requestURL = BASE_URL + "hotels/" +reservation.getHotelID() + "/reservations";
	  															
	//DEAL WITH ERRORS
	  try {															//requestURL //body content //return type
		  Reservation createdReservation = restTemplate.postForObject(requestURL, 	entity, 	Reservation.class);//expecting Reservation back therefore Reservation.class as 3rd parameter
		  return createdReservation;
		  //this error means I talked to API & the API threw an exception
	  }catch(RestClientResponseException ex) {
		  console.printError(ex.getRawStatusCode() + ": " + ex.getStatusText());
		 //this error means I wasn't able to access API at all
	  }catch(ResourceAccessException ex) {
		  console.printError(ex.getMessage());
	  }
	  
    return null; //return null if try fails
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param CSV
   * @return
   */
  public Reservation updateReservation(String CSV) {
	  Reservation reservation = this.makeReservation(CSV); 
	  if(reservation == null) {
		  return null; 
	  }
	  HttpHeaders headers = new HttpHeaders(); 
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  				
	  HttpEntity<Reservation> entity = new HttpEntity<Reservation>(reservation, headers);
	  
	  try {
		  String requestURL = BASE_URL + "reservations/" + reservation.getId(); //need id identifier
		  restTemplate.put(requestURL, entity); //no return object b/c PUT is REPLACE ALL
		  return reservation;
	  }catch(RestClientResponseException ex) {
	   console.printError(ex.getStatusText() + " : " + ex.getStatusText());
	  }catch(ResourceAccessException ex) {
	   console.printError(ex.getMessage());
	  }
	  return null; // if fail, return null
  	}

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public boolean deleteReservation(int id) { 
   String requestURL = BASE_URL + "reservations/" + id; //need the id to know which record to delete
   try {
	   restTemplate.delete(requestURL); //doesn't need body nor response back
	   return true;
   }catch(RestClientResponseException ex) {
	   console.printError(ex.getStatusText() + " : " + ex.getStatusText());
   }catch(ResourceAccessException ex) {
	   console.printError(ex.getMessage());
   }
   return false;
  }

  /* DON'T MODIFY ANY METHODS BELOW */

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null; //default to null value if can't get object
    try {
      hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) { //if don't receive 200 status code
      // handles exceptions thrown by rest template and contains status codes
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText()); 
    } catch (ResourceAccessException ex) { //if server failure (can't get to API) usually message is "Wait 5min, try again."
      // i/o error, ex: the server isn't running
      console.printError(ex.getMessage());
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
    	if(ex.getRawStatusCode() == 404) {
    		console.printError("No such reservation exists. Please try again.");
    	} else {
    		console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    	}
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  //READ AT OWN PACE
  //should remind of capstone load inventory functionality
  private Reservation makeReservation(String CSV) {
    String[] parsed = CSV.split(",");

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) {
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
