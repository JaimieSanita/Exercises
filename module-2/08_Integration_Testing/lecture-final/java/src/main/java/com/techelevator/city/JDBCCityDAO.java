package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;

	// this is where, somewhere offscreen we could load the database 
	// connection string, and credentials from a secure file, or secret store
	// and then construct a database, which we pass into this object
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	

	@Override
	public void create(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) "
				+ "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), newCity.getName(), newCity.getCountryCode(),
				newCity.getDistrict(), newCity.getPopulation());
	}

	
	
	
	
	
	
	@Override
	public City findCityById(long id) {
		
		// City is null because we haven't found it yet!
		City theCity = null;
		
		// we need a query to run against sql to find a city
		String sqlFindCityById = "SELECT id, name, countrycode, district, population " + 
								 "FROM city " + 
								 "WHERE id = ?";
		
		
		// execute the query against the database, using our shared jdbcTemplate object
		// we put in the query as the first argument, then any parameters to the query
		// as subsequent arguments
		
    //  represents collection of rows            //execute query              query           arg1, arg2, etc
		SqlRowSet results                =       jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		
		
		if (results.next()) {
			theCity = mapRowToCity(results);
		}
		
		// why no else? we don't care
		
		return theCity;
	}

	
	
	
	
	
	
	
	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population " + "FROM city "
				+ "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while (results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population " + "FROM city "
				+ "WHERE district = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, district);
		while (results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public void update(City city) {
		String sql = "UPDATE city set name = ?, countrycode = ?, district = ?, population = ? WHERE id = ?";
		jdbcTemplate.update(sql,city.getName(),city.getCountryCode(),city.getDistrict(),city.getPopulation(),city.getId());
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update("DELETE FROM city WHERE id = ?",id);
	}

	
	
	
	
	
	
	// OLD SKOOL get the next city ID
	// used when we are creating a new city.
	private long getNextCityId() {
		// call a sql function to get the next city_id from the sequence (serial datatype)
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if (nextIdResult.next()) {
			// column index. instead, we could use an 'AS' expression above in the query
			// and access by column name with a string "column_name"
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	//helper function
	// given a SQL Row (in a SqlRowSet object) representing a city
	// map that sql row into a real city object. Using the get{Type} methods on the SqlRowSet
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
