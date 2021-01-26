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
  private final ConsoleService console;

  public HotelService(String url, ConsoleService console) {
    BASE_URL = url;
    this.console = console;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
    // turn the string into a reservation object
	Reservation reservation = this.makeReservation(newReservation);
	
	if(reservation == null) {
		return null;
	}
	  
	// make our api call to insert the reservation object
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	
	
	
	HttpEntity<Reservation> entity = new HttpEntity<Reservation>(reservation,headers);
	
	                       //http://localhost/hotels/1234/reservations
	String requestUrl = BASE_URL + "hotels/" + reservation.getHotelID() + "/reservations";
	
	try {
		//                                                            url         body content    return type
		Reservation createdReservation  = restTemplate.postForObject(requestUrl,    entity,      Reservation.class);
		return createdReservation;
	// this error means I talked to the api, and it didn't like what I said
	} catch (RestClientResponseException ex) {
		console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		
	// this error means I was unable to access the api at all
	} catch (ResourceAccessException ex) {
		console.printError(ex.getMessage());
	}
	  
    return null;
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
    
    //make my headers
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    //make my http entity
    								//             <> is shorthand for use the type from the left side of the expression
    HttpEntity<Reservation> entity = new HttpEntity<>(reservation,headers);
       
    //do my put request
	
    try {
    	String requestUrl  = BASE_URL + "reservations/" + reservation.getId();
    	
    	// updates the record with a PUT request
    	// think of the PUT verb as replace all
    	restTemplate.put(requestUrl, entity);
    	
    	return reservation;
    	
    } catch(RestClientResponseException ex) {
    	console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
    	console.printError(ex.getMessage());
    }
    
    
    // if I get here, I had a failure and should return null
    return null;
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public boolean deleteReservation(int id) {
    String requestUrl = BASE_URL + "reservations/" + id;
    try {
    	restTemplate.delete(requestUrl);
    	return true;
    } catch(RestClientResponseException ex) {
    	console.printError(ex.getStatusText() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
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
    Hotel[] hotels = null;
    try {
      hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) {
      // handles exceptions thrown by rest template and contains status codes
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
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
    		// maybe I would also log the full error message to my loggging system here
    		console.printError("No such reservation exists, try again...");
    		
    	} else {
    		console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    	}
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  // Read this at your own pace
  // this should remind you very strongly of your
  // capstone load inventory functionality
  
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
