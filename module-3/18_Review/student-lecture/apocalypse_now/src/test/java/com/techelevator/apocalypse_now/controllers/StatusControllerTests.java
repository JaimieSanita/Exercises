package com.techelevator.apocalypse_now.controllers;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.apocalypse_now.models.Status;

public class StatusControllerTests {

	@Test
	public void basicStatusTest() {
		// Arrange
		StatusController controller = new StatusController(new MockStatusDAO());
		
		//Act
		Status status = controller.getCurrentStatus();
		
		// Assert
		Assert.assertNotNull(status);
	}
	
}
