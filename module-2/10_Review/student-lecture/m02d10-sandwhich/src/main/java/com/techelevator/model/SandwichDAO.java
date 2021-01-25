package com.techelevator.model;

import java.util.List;

public interface SandwichDAO { //defines all methods for how we can manipulate data
	
	
	//CRUD; CREATE READ UPDATE DELETE
	//usually START WITH READ
	
	Sandwich getById(int id); //don't need imports if classes in same package
	List<Sandwich> getAll();
	List<Sandwich> getByType(String typeName);
	List<Sandwich> getByTypes(List<String> typeNames);
	

}
