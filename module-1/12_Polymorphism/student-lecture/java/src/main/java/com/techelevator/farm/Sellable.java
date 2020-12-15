package com.techelevator.farm;

import java.math.BigDecimal;

public interface Sellable {

	String getName();
	
	BigDecimal getPrice(); //use BigDecimal when performing math; precisely rep decimal numbers but exact, no rounding errors
	
	String getMeal();

}
