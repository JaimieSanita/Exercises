package com.techelevator.model.jdbc;

import com.techelevator.model.SandwichDAO;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.Sandwich;
import com.techelevator.model.Category;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSandwichDAO implements SandwichDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCSandwichDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Sandwich getById(int id) {
		String query =	"SELECT id, name, description, price, unit_price, is_available " +
						"FROM menu  " +
						"WHERE id = ?";
		
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, id);
		
		Sandwich toReturn = null;
		if(results.next()) {
			toReturn = this.mapRowToSandwich(results, new ArrayList<Category>());
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

	private Sandwich mapRowToSandwich(SqlRowSet row, List<Category> categories) {
		Sandwich theSandwich = new Sandwich(categories);
		
		theSandwich.setId(row.getInt("id"));
		theSandwich.setAvailable(row.getBoolean("is_available"));
		theSandwich.setDescription(row.getString("description"));
		theSandwich.setName(row.getString("name"));
		theSandwich.setPrice(row.getBigDecimal("price"));
		theSandwich.setUnitPrice(row.getBigDecimal("unit_price"));
		
		return theSandwich;
	}
	
}
