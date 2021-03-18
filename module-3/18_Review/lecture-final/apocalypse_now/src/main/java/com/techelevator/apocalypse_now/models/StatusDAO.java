package com.techelevator.apocalypse_now.models;

import java.util.List;

public interface StatusDAO {

	Status getCurrent();
	List<Status> getAll();
	
}
