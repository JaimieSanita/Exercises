package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {
	

    public static void main(String[] args) {

        // Step One: Declare a Map
    	Map<String,Boolean> cats = new HashMap<String, Boolean>();
    	
    	// Step Two: Add items to a Map
    	cats.put("Emerson", true);
    	cats.put("Nora", true);
    	cats.put("Jaimie", false);
    	cats.put("Diandra",  false);
    	
    	// Step Three: Loop through a Map
    	for (Map.Entry<String, Boolean> cat : cats.entrySet()) {
    		if (cat.getValue()) {
    			System.out.println(cat.getKey() + " is a cat." );
    		} else {
    			System.out.println(cat.getKey() + " is not a cat.");
    		}
    	}
    }

}
