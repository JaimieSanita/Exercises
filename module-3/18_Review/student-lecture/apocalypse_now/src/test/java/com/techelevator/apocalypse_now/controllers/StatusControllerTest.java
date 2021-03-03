package com.techelevator.apocalypse_now.controllers;

import org.junit.Assert;
import org.junit.Test;
import com.techelevator.apocalypse_now.models.Status;

public class StatusControllerTest {
	
	@Test
	public void basicStatusTest() {
		//ARRANGE
		StatusController controller = new StatusController(new MockStatusDAO());
		//ACT
		Status status = controller.getCurrentStatus();
		//ASSERT
		Assert.assertNotNull(status);
	}

}
