package com.techelevator.cocktail.dao.psql;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.cocktail.models.Cocktail;
import com.techelevator.cocktail.models.CocktailDAO;
import com.techelevator.cocktail.models.CocktailNotFoundException;

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
			Cocktail cocktail = mapRowToCocktail(results);
			cocktails.add(cocktail);
		}
		
		return cocktails;
	}

	@Override
	public Cocktail getById(int id) throws CocktailNotFoundException {
		
		String query = "SELECT id, name, alcoholic FROM cocktail WHERE id = ?";
		
		SqlRowSet result = template.queryForRowSet(query,id);
		
		if(result.next()) {
			return mapRowToCocktail(result);
		} else {
			throw new CocktailNotFoundException(id);
		}
	}
	
	private Cocktail mapRowToCocktail(SqlRowSet row) {
		return new Cocktail(
				row.getInt("id"),
				row.getString("name")
				);
	}

}
