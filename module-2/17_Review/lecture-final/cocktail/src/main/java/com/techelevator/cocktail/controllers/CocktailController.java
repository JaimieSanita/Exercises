package com.techelevator.cocktail.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.cocktail.models.Cocktail;
import com.techelevator.cocktail.models.CocktailDAO;
import com.techelevator.cocktail.models.CocktailNotFoundException;

@RequestMapping("/cocktail")
@RestController
public class CocktailController {

	private CocktailDAO dao;
	
	public CocktailController(CocktailDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public List<Cocktail> getAll(){
		return this.dao.getAll();
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public Cocktail getById(@PathVariable int id) throws CocktailNotFoundException {
		return this.dao.getById(id);
	}
	
	//TODO CREATE
	
	
	
	//TODO UPDATE
	
	//TODO DELETE ?
	
	//TODO Search ?
	
}
