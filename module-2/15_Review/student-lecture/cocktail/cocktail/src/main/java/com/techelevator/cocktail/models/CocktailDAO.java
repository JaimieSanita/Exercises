package com.techelevator.cocktail.models;

import java.util.List;

public interface CocktailDAO {
	//build out 
	List<Cocktail> getAll();
	
	Cocktail getById(int id);
	

}
