package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		//wrapper object that you pass resource through
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		
		
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String sqlFilmsByCategory =  "SELECT film.title, film.release_year "+
									 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
									 "JOIN category ON category.category_id = film_category.category_id "+
									 "WHERE category.name = ? OR category.name = ?";
		
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */
		String category = "Comedy";
		String secondCategory = "Drama";
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByCategory, category, secondCategory);
		//parameterized query with arguments to query & automatically handles order; condenses 4 lines of code into 1
		//under the hood Spring is calling JDBC
		//the String sqlFilmsByCategory must be 1:1 with SqlRowSet results

		
		System.out.println(category +" or " + secondCategory + " Films:");
		while(results.next()) {  // The "next" method advances the cursor to the next row.  If a row exists, it returns true, otherwise false
			String filmTitle = results.getString("title");  // this is the title column from the SELECT statement above
			int releaseYear = results.getInt("release_year");
			System.out.println(filmTitle + " (" + releaseYear + ")");
		}
		
		
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		//statements that don't return anything to use
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) "+
								"VALUES (?, ?, ?)";
									//string		//?	//?			//?
		//if craig is already ,inserted, can't insert him again
		//dvdstoreJdbcTemplate.update(sqlCreateActor, 1000, "Craig", "Castelaz");
		
		//no results method because update method won't display anything on console, check on DBVisualizer
		 
		/* The next example makes use of the world database, so we need a new 
		 * DataSource for creating connections to that database. */
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate worldJdbcTemplate = new JdbcTemplate(worldDataSource);
		
		/*
		 * Sequences are often used to generate a unique Id value prior to inserting
		 * a new record.
		 */
		//START OF OLD METHOD OF FINDING ID
		String sqlGetNextId = "SELECT nextval('seq_city_id') AS city_id"; //whenever create serial, there is underlying sequence
		//normally w/ multiple results we'd have a while loop
		//but there's only one result so we can advance manually
		results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);//get the row with matching id; results is instance of Object that points
		//to any row set, resetting instance
		
		results.next(); // advances to the first row, need to call result
		
		int id = results.getInt(1); // returns the integer value of the first column (i.e. index 1) indexes of 1 NOT 0
									//can also put column name inside ("city_id")
		System.out.println("New city id: " + id); //each time run, will print next id serially
		//END OF OLD METHOD OF FINDING ID
		/*
		 * Now create a new city record using the generated id 
		 */
		
		
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) " +
								  "VALUES(?, ?, ?, ?, ?)";
								//SQLstring		//int	//?			//?		//?		//?
		worldJdbcTemplate.update(sqlCreateNewCity, id, "Smallville", "USA", "Kansas", 45001);
		
		
		//MORE SUCCINCT VERSION
		
		String createNewCityReturning = "INSERT INTO city(name, countrycode, district, population) " + "VALUES (?, ?, ?, ?) "
											+ "RETURNING id, name, countrycode, district, population";
		
		SqlRowSet cityResults = worldJdbcTemplate.queryForRowSet(createNewCityReturning, "Smallville-Earth 2", "USA", "Kansas", 34);
		//advance row set to the first row
		cityResults.next();
		
		int cityId = cityResults.getInt("id");
		System.out.println("The ID I created via RETURNING was: " + cityId);
	}
}
