package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {
	//constant value; fake country_code
	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	//Database connections are expensive; 
	//dataSource that guarantees this program only speaks to database once; 
	//one at a time & tests will run in linear order, only one at a time
	//isolates tests from one another
	private static SingleConnectionDataSource dataSource;
	
	
	//the DAO we are going to use in testing
	//create DAO but not initialized
	private JDBCCityDAO dao;
	

	/* Before any tests are run, this method initializes the datasource for testing. */
	//BEFORE EVERY FILE (STATIC)
	//setup datasource; shared for all tests in file
	//copy/paste
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false); //anything performed will be in a transaction;
										//therefore if anything updated, can be rolled back
										//next test runs clean
	}

	//AFTER FILE (STATIC)
	/* After all tests have finished running, this method will close the DataSource */
	//frees up resources in postgres; no longer connected to database
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	//BEFORE EVERY TEST (NOT STATIC)
	//once per test
	@Before
	public void setup() { //NOT TESTING COUNTRY TABLE, TESTING CITY DAO but need country in database to key
		//insert fake country into DB & can trust that country is available to use
		//test do not need to depeond on data in the database
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		//construct template object, necessary for DAO creation
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//insert country into jdbctemplate with testcountry as parameter
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		//setup DAO field so tests have valid & clean DAO to work with
		dao = new JDBCCityDAO(dataSource);
	}

	//AFTER EVERY TEST (NOT STATIC)
	//once per test
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test //create new city; make first b/c if doesn't work, nothing else will
	public void save_new_city_and_read_it_back() throws SQLException {
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);

		dao.create(theCity);
		City savedCity = dao.findCityById(theCity.getId());

		assertNotEquals(null, theCity.getId());
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_cities_by_country_code() {
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		dao.create(theCity);
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_multiple_cities_by_country_code() {
		//ARRANGE (add two cities to test_country)
		dao.create(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.create(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));
		//ACT(call method on dao testing)
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		//ASSERT
		assertNotNull(results); //get list of cities back 
		assertEquals(2, results.size()); //get two back
		
		for(City city : results) { //results have correct country_code
			assertEquals(TEST_COUNTRY, city.getCountryCode());
		}
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.create(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
	//builds fake City object for it
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {
		//check expected getters, equal actual getters
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
