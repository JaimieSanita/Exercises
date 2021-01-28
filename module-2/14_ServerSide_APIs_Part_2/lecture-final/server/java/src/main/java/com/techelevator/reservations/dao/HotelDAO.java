package com.techelevator.reservations.dao;

import com.techelevator.reservations.models.Hotel;

import java.util.List;

public interface HotelDAO {

    List<Hotel> list();

    List<Hotel> getByState(String state);
    List<Hotel> getByCity(String city, String state);
    void create(Hotel hotel);

    Hotel get(int id);
    
    

}