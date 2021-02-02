package com.techelevator.cocktail.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cocktail not found.") //this will ensure that a 404 error will throw when a bad(out of bounds) id is tried
public class CocktailNotFoundException extends Exception{
	
	
	public CocktailNotFoundException(int cocktailId) { //write own constructor as override
		super("Cocktail " +cocktailId+ "cannot be found!");
	}

}
