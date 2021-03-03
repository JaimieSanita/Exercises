package com.techelevator.apocalypse_now.controllers;

import java.util.List;

import com.techelevator.apocalypse_now.models.Status;
import com.techelevator.apocalypse_now.models.StatusDAO;

public class MockStatusDAO implements StatusDAO {

	@Override
	public Status getCurrent() {
		Status status = new Status();
		
		return null;
	}

	@Override
	public List<Status> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
