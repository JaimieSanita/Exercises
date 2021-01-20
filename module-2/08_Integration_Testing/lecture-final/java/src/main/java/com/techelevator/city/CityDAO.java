package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	// when we're dealing with records, some require the "id" field to be set
	// others, like this one allow a record with a 0 ID and create the record
	public void create(City newCity);

	public City findCityById(long id);

	public List<City> findCityByCountryCode(String countryCode);

	public List<City> findCityByDistrict(String district);

	// Here, the "id" of the city must be set, or the operation will fail
	public void update(City city);

	public void delete(long id);
}
