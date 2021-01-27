package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

	private HotelDAO hotelDAO;
	private ReservationDAO reservationDAO;

	public HotelController() {
		this.hotelDAO = new MemoryHotelDAO();
		this.reservationDAO = new MemoryReservationDAO(hotelDAO);
	}

	/**
	 * Return All Hotels
	 *
	 * @return a list of all hotels in the system
	 */
	// path isn't full path but fraction of path that goes after what server starts
	// with
	@RequestMapping(path = "/hotels", method = RequestMethod.GET) // interpret as web URL; path variable tells us what
																	// route this method responds to
																	// respond to HTTP GET request with below method
	public List<Hotel> list() {
		return hotelDAO.list();
	}

	/**
	 * Return hotel information
	 *
	 * @param id the id of the hotel
	 * @return all info for a given hotel
	 */
	@RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
	public Hotel get(@PathVariable int id) {
		return hotelDAO.get(id);
	}

	/**
	 * 
	 * @return all info for any reservation in the system
	 * 
	 */
	// LIST ALL RESERVATIONS
	@RequestMapping(path = "/reservations", method = RequestMethod.GET)
	public List<Reservation> listReservations() {
		return this.reservationDAO.findAll();
	}

	/**
	 * 
	 * @param reservationID
	 * @return A single reservation with the given ID, or null
	 * 
	 */
	// GET A RESERVATION BY ID
	@RequestMapping(path = "/reservations/{reservationID}", method = RequestMethod.GET)
	public Reservation getReservationByID(@PathVariable int reservationID) { // need to tell Spring this is the variable
																				// to use
		return this.reservationDAO.get(reservationID);
	}

	/**
	 * 
	 * @param hotelID
	 * @return A list of reservations for a specified hotel
	 */

	// LIST ALL RESERVATIONS PER HOTEL
	@RequestMapping(path = "/hotels/{hotelID}/reservations", method = RequestMethod.GET)
	public List<Reservation> reservationListByHotel(@PathVariable int hotelID) {
		return this.reservationDAO.findByHotel(hotelID);
	}

	// ADD NEW RESERVATION
	@RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
	public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable ("id") int hotelID) {
		return this.reservationDAO.create(reservation, hotelID);
	}

	/**
	 * 
	 * @param @required state to filter on
	 * @param @optional city to filter on
	 * @return list of Hotels that match the provided state and optional city
	 */
	// FILTER HOTELS BY STATE AND/OR CITY
	@RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)			//this parameter is not required
	public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(required = false) String city){ //by default, @RequestParam must be provided
    	List<Hotel> filteredHotels = new ArrayList<>();
    	List<Hotel> allHotels = this.list();//note that we can call @requestmap methods like any other java methods; but probably wouldn't do the since DAO already has list method on it
    	for(Hotel hotel : allHotels) {
    		if(city != null) {
    			if(hotel.getAddress() != null && hotel.getAddress().getCity().equalsIgnoreCase(city) && hotel.getAddress().getState().equalsIgnoreCase(state)) {
    				filteredHotels.add(hotel);
    			}
    		} else if (hotel.getAddress() != null && hotel.getAddress().getState().equals(state)) {
    				filteredHotels.add(hotel);
    			} 		
    	}
    
    	return filteredHotels;
    }

}
