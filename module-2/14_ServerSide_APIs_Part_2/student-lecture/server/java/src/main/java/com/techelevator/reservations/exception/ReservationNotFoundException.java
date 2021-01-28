package com.techelevator.reservations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Reservation not found.") //if this exception is thrown, return status code 404(not found)

//inheriting from base Exception type
//when fetching or deleting reservation
public class ReservationNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ReservationNotFoundException() {
        super("Reservation not found."); //requires message
    }
}
