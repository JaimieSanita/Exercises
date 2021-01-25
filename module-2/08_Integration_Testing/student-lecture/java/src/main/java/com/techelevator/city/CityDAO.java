package com.techelevator.city;

import java.util.List;

//DONE IN ADVANCE OF PROGRAM
//WHAT WE NEED TO BE ABLE TO DO
//WHAT SYSTEM NEEDS TO   DO ITS JOB
public interface CityDAO {

	//WHEN DEALING WITH RECORDS, SOME REQUIRE ID TO BE SET, WHILE OTHERS LIKE THE BELOW, ALLOW A RECORD WITH A 0 ID & CREATE RECORD
	public void create(City newCity);

	public City findCityById(long id);

	public List<City> findCityByCountryCode(String countryCode);

	public List<City> findCityByDistrict(String district);

	//HERE THE ID OF THE CITY MUST BE SET OTHERWISE OPERATION WILL FAIL
	public void update(City city);

	public void delete(long id);
}
