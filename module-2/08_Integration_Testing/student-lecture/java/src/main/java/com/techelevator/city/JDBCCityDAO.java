package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;

	//CONSTRUCTOR(create JdbcTemplate object out of dataSource to use in other methods)
	//where someone could load the database connection string & credentials from a secure file and then
	//construct a data source which we pass into this object
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	//METHOD IMPLEMENTATIONS
	@Override //methods from interface
	public void create(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) "
				+ "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), newCity.getName(), newCity.getCountryCode(),
				newCity.getDistrict(), newCity.getPopulation());
	}

	
	
	
	@Override
	public City findCityById(long id) {
		City theCity = null; //default to null b/c no id known yet; reference type variable
		//don't forget space after Select & From clauses; otherwise "populationFrom"
		//list out all columns rather than using *
		String sqlFindCityById = "SELECT id, name, countrycode, district, population " + "FROM city " + "WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if (results.next()) { //only looking for one row, therefore use if conditional, not while loop
			theCity = mapRowToCity(results);
		}
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

	private long getNextCityId() { //helper method; use when creating a new city
		//call SQL function to get the next city_id from sequence (serial datatype)
																//sql identifier
																//could use RETURNING instead
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if (nextIdResult.next()) {
			//column index
			//instead we could use an AS expresion avove in the query and access column name with a string
			//"column name"
			return nextIdResult.getLong(1);
		} else { //rest of our steps are dependent of this happening therefore need to throw exception, something wrong with sql
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	
	//helper function
	//given sql row (in a sqlrowset object) representing a city 
	//map that sql row into a real city object
	//use the getType methods on the sqlrowset
	private City mapRowToCity(SqlRowSet results) { //helper method
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
