package com.techelevator.cocktail.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Cocktail not found.")
public class CocktailNotFoundException extends Exception {
	
	//CONSTRUCTOR
	public CocktailNotFoundException(int cocktailId) {
		super("Cocktail "+cocktailId + " cannot be found!");
	}

}
