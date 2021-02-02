package com.techelevator.cocktail.dao.psql;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.cocktail.models.Cocktail;
import com.techelevator.cocktail.models.CocktailDAO;

@Component
public class JDBCCocktailDAO implements CocktailDAO {

	private JdbcTemplate template;
	
	public JDBCCocktailDAO(DataSource datasource) {
		this.template = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Cocktail> getAll() {
		List<Cocktail> cocktails = new ArrayList<Cocktail>();
		
		
		String query = "SELECT id, name, alcoholic FROM cocktail";
		
		SqlRowSet results = template.queryForRowSet(query);
		
		while(results.next()) {
			Cocktail cocktail = new Cocktail(
					results.getInt("id"),
					results.getString("name")
					);
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
