package com.techelevator.model;

import java.util.List;

public interface SandwichDAO {
	
	// CRUD - Create Read Update Delete
	// I would usually start with READ so you can things
	
	Sandwich getById(int id);
	List<Sandwich> getAll();
	List<Sandwich> getByType(String typeName);
	List<Sandwich> getByTypes(List<String> typeNames);

}
