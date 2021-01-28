package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//we can add a path prefix her that applies to all of the routes below
//if we wanted the raw get we could set path = " or omit path from RequestMapping
//@RequestMapping("/api/v1")
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    public HotelController(HotelDAO hotelDAO, ReservationDAO reservationDAO) { //accepting dao as arguments in constructor
    																		//therefore controller is not dependent on DAO
    																		//Spring is creating new controllers under the hood
        this.hotelDAO = hotelDAO;
        this.reservationDAO = reservationDAO;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
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
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDAO.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) throws ReservationNotFoundException {
        return reservationDAO.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelID
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelID) throws HotelNotFoundException {
        return reservationDAO.findByHotel(hotelID);
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     * @param hotelID
     */
    
    //if succeed, return response status CREATED 201
    @ResponseStatus(HttpStatus.CREATED) //changes response status setup when successfully exit method
    				//URL-----------------------------	HTTP Request Method--------
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    //	 Returns Reservation object		called addReservation	requires validadated parameters: a Reservation instance------------- and int hotelID-----------------
    public Reservation 					addReservation			(@Valid @RequestBody 			Reservation reservation, @PathVariable("id") int hotelID)
            throws HotelNotFoundException {
        //returns a JSON object in the shape of Reservation body that is deserialized
    	return reservationDAO.create(reservation, hotelID);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int id) throws ReservationNotFoundException {
    	 this.reservationDAO.delete(id);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * /hotels/filter?state=oh&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(required = false) String city) {
    	if(city != null) {
    		return this.hotelDAO.getByCity(city, state);
    	} else {
    		return this.hotelDAO.getByState(state);
    	}
    }

}
