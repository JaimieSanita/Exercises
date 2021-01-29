package com.techelevator.cocktail.dao.psql;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.cocktail.models.Cocktail;
import com.techelevator.cocktail.models.CocktailDAO;

@Component //allows to take dependencies from Spring and allows this class to be offered as resource
public class JDBCCocktailDAO implements CocktailDAO {

	private JdbcTemplate template;
	
	public JDBCCocktailDAO(DataSource datasource) { //need to pass DataSource into constructor
		template = new JdbcTemplate(datasource);
	}
	
		
	@Override
	public List<Cocktail> getAll() {
		List<Cocktail> cocktails = new ArrayList<>();
		String query = "SELECT id, name, alcoholic FROM cocktail";
		SqlRowSet results = template.queryForRowSet(query);
		while(results.next()) {
		//use helper method to map
		Cocktail cocktail = new Cocktail(results.getInt("id"), results.getString("name"));
		cocktails.add(cocktail);
		}
		return cocktails;
	}

	@Override
	public Cocktail getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
