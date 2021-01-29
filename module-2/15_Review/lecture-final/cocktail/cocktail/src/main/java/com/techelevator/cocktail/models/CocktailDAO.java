package com.techelevator.cocktail.models;

import java.util.List;

public interface CocktailDAO {

	List<Cocktail> getAll();
	Cocktail getById(int id);
	
}
