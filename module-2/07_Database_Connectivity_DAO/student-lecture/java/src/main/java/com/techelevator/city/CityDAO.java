package com.techelevator.city;

import java.util.List;

//INTERFACE: DEFINES ALL CAPABILITIES PROVIDING
//if working on a team, do this first
public interface CityDAO {

	
	//THESE METHODS PROVIDE THE CRUD (create, read, update, delete) OPERATON ON CITIES; PLUS A FEW EXTRA METHOD
	public void save(City newCity); //SAVES CITY INTO DB, TAKES CITY AND RETURNS NOTHING
	public City findCityById(long id); //
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city); //TAKES CITY AND SAVES IT
	public void delete(long id); //DELETES A CITY AND SAVES IT
}
