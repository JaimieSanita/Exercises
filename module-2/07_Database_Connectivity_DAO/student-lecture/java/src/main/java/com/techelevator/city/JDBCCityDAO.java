package com.techelevator.city;
//lots of imports, BEAST
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate; //CAN SHARE TEMPLATE OBJECT
	
	public JDBCCityDAO(DataSource dataSource) { //CONSTRUCTOR
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  newCity.getName(),
										  newCity.getCountryCode(),
										  newCity.getDistrict(),
										  newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) { //ACCEPTS CITY ID
		City theCity = null; //MAKE VARIABLE TO HOLD CITY
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?"; //WRITE QUERY
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id); //RUNS QUERY AND SUB ID FOR ?
		if(results.next()) { //IF HAVE 1 ROW, WHICH SHOULD ; IF NOT (false), RETURN NULL
			theCity = mapRowToCity(results); //MAPS SQL ROW INTO A CITY 
		}
		return theCity;  //RETURN CITY OBJECT with SQL info matching id
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		List<City> citiesToReturn = new ArrayList<City>();
		
		//write a query that gets cities by provided district (String sql)
		String query = "SELECT * FROM city WHERE  district = ?";
		//execute query against database (SqlRowSet results)
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, district);
		//while loop over result set (result.next)
		while(results.next()) {
		
		//convert a row into a City
			City resultCity = this.mapRowToCity(results);
			
			//add city in list
			citiesToReturn.add(resultCity);
		}
		
		
		
		return citiesToReturn;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}
	
	//HELPER METHOD
	private City mapRowToCity(SqlRowSet results) {
		City theCity; //THIS ROW & 87 MAKE NEW CITY
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
