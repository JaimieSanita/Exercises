package com.techelevator.model;

import java.util.List;

public interface ExerciseDAO {

	public List<Exercise> getAllSamples();
	public Exercise getSampleByID(long id);
	public Exercise getSampleByName(String name);
	public Exercise createSample(long id, String name);
	public Exercise updateSample(long id, String name);
	public void removeSampleByID(long id);
	
}
