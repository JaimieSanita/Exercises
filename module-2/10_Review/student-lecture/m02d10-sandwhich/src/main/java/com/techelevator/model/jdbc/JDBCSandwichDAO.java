package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Exercise;
import com.techelevator.model.ExerciseDAO;
import com.techelevator.model.SandwichDAO;
import com.techelevator.model.Category;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.model.Sandwich;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCSandwichDAO implements SandwichDAO{
	
	//programming against interface therefore can change databases by editing one line
	//can create fake implementation for testing b/c implements interface & don't need to connect to database


	private JdbcTemplate jdbcTemplate;
	
	//CONSTRUCTOR
	JDBCSandwichDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate (dataSource);
	}
	@Override
	public Sandwich getById(int id) {
		String query = "SELECT id, name, description, price, unit_price, is_available " +
						"FROM menu " +
						"WHERE id = ?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, id); //returns row with matching id
		
		Sandwich toReturn = null;
		if(results.next()) { //if i can advance to next row
			toReturn = this.mapRowToSandwich(results, new ArrayList<Category>()); //created new list
		}
		return toReturn;
	}

	@Override
	public List<Sandwich> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sandwich> getByType(String typeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sandwich> getByTypes(List<String> typeNames) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	private Sandwich mapRowToSandwich(SqlRowSet row, List<Category> categories) { //take row & get object back
		Sandwich sandwich = new Sandwich(categories);
		sandwich.setId(row.getInt("id"));
		sandwich.setName(row.getString("name"));
		sandwich.setAvailable(row.getBoolean("is_available"));
		sandwich.setDescription(row.getString("description"));
		sandwich.setPrice(row.getBigDecimal("price"));
		sandwich.setUnitPrice(row.getBigDecimal("unit_price"));
		
		return sandwich;
		
	}
	
}
