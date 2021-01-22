package com.techelevator.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Exercise;
import com.techelevator.model.ExerciseDAO;

public class JDBCExerciseDAO implements ExerciseDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCExerciseDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Exercise> getAllSamples() {
		// TODO 
		return null;
	}

	@Override
	public Exercise getSampleByID(long id) {
		// TODO 
		return null;
	}

	@Override
	public Exercise getSampleByName(String name) {
		// TODO 
		return null;
	}

	@Override
	public Exercise createSample(long id, String name) {
		// TODO 
		return null;
	}

	@Override
	public Exercise updateSample(long id, String name) {
		// TODO 
		return null;
	}

	@Override
	public void removeSampleByID(long id) {
		// TODO 
	}

}
