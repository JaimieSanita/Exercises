package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	// These methods provide the CRUD operation on cities, plus a few extra methods
	
	public void save(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city);
	public void delete(long id);
}
