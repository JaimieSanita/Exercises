package com.techelevator.apocalypse_now.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.apocalypse_now.models.Status;
import com.techelevator.apocalypse_now.models.StatusDAO;

@RestController
public class StatusController {
	
	private StatusDAO statusDAO;
	
	public StatusController(StatusDAO dao) {
		this.statusDAO = dao;
	}
	
	@RequestMapping("/api/status/current")
	public Status getCurrentStatus() {
		return this.statusDAO.getCurrent(); //loads status out of database
	}


}
