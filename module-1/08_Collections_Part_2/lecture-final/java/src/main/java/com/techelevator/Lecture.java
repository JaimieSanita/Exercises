package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();
		
		// keep track of our inventory for the current player
		Map<String,Integer> inventory = new HashMap<String,Integer>();
		
		Map<String,List<String>> players = new HashMap<String, List<String>>(); 

		/***
		 * 
		 * 
		 * Putting things into a map or replacing them
		 * 
		 */
		
		// load up our inventory
		inventory.put("pokeball", 10);
		inventory.put("potion", 5);
		inventory.put("rare candy", 1);
		
		//replace an item
		inventory.put("pokeball", 15);
		
		
		/****
		 * 
		 * Adding the first player
		 * 
		 */
		
		
		// for comparison, we'll make a list for our player
		List<String> ourPlayer = new ArrayList<String>();
		ourPlayer.add("Charmander");
		ourPlayer.add("Bulbasaur");
		ourPlayer.add("Squirtle");
		
		// put the player into the player map
		players.put("Ash", ourPlayer);
		
		
		
		/**
		 * 
		 * Fetching items out of a map
		 * 
		 */
		
		System.out.println("We have " + inventory.get("pokeball") + " pokeballs");
		
		// What happens now?
		//System.out.println("We have " + inventory.get("ultraball") + " ultraballs");
		
		//better version
		if(inventory.containsKey("ultraball")) {
			System.out.println("We have " + inventory.get("ultraball") + " ultraballs");
		}
		
		/***
		 * 
		 * Iterating over the contents of a map
		 * 
		 * Either by getting the keys (map.keySet) or the Map.Entry (map.entrySet)
		 * 
		 */
		
		/*
		Set<String> inventoryKeys = inventory.keySet();
		for(String itemKey : inventoryKeys) {
			System.out.println(itemKey + " : " + inventory.get(itemKey));
		}
		*/
		
		// I can loop over all the things in a map
		for(Map.Entry<String,Integer> inventoryItem : inventory.entrySet()) {
			//  the item names are our mapKeys
			String itemName = inventoryItem.getKey();
			// the map values are our quantity
			int quantity = inventoryItem.getValue();
			
			System.out.println(itemName + " : " + quantity);
		}
	
		
		/**
		 * 
		 * 
		 * Adding additional players
		 * 
		 */
		
		//a variable we can use to refer to our new players
		List<String> tempPlayer = null;
		
		// create a new player by instantiating a new array list and assigning that value to our 'otherPlayer' variable
		tempPlayer = new ArrayList<String>();
		tempPlayer.add("Pidgey");
		
		// at this point, the the list is stored in the 'players' map
		players.put("Trainer Kid",tempPlayer);
		
		// the map is now tracking 'Trainer Kid' so I don't need the variable
		tempPlayer = null;
		
		// assigning an existing variable to a new reference value
		tempPlayer = new ArrayList<String>();
		tempPlayer.add("Gyarados");
		tempPlayer.add("Dragonite");
		tempPlayer.add("Alakazam");
		
		players.put("Gary", tempPlayer);
		
		tempPlayer = null;
		
		tempPlayer = new ArrayList<String>();
		tempPlayer.add("Pikachu");
		players.put("Professor Oak", tempPlayer);
		
		// just for safety so I don't accidentally add or remove a pokemon to Prof. Oak unintentionally
		tempPlayer = null;
		
		// print blank lines for spacing
		System.out.println("\n\n");
		
		for(Map.Entry<String,List<String>> player : players.entrySet()) {
			// Print out the name of the character (map key)
			System.out.println("Roster for " + player.getKey() + " :");
			
			// Get the map value (List<String>) and store it in a variable
			List<String> playerPokemon = player.getValue();
			
			// Loop over all the pokemon for this player
			for(String pokemon : playerPokemon) {
				// print the individual pokemon with a couple tabs to indent it
				System.out.println("\t\t" + pokemon);
			}
			// print a blank line so the next player starts out after an empty line
			System.out.println();
		}
		
		
		/***
		 * 
		 * Write a "use a potion" snippet
		 *
		 * Potion is in our inventory
		 */
		
		// Get the quantity out of our inventory
		// update the quantity with a new value 
		
		// get a potion out of our inventory
		int currentQuantity = inventory.get("potion");
		
		//decrement the value to consume a single potion
		currentQuantity--;
		
		// put the updated amount back into the map
		inventory.put("potion", currentQuantity);
		
		/***
		 * 
		 * A new Map
		 * 
		 */
		
		//Make a new map
		Map<String,Double> myTeamsHealth = new HashMap<String,Double>();
		
		//Get the list of pokemon for ash
		List<String> ashPokemon = players.get("Ash");
	
		//Put each pokemon into the health map and give it 100.0 health to start
		for(String poke : ashPokemon) {
			myTeamsHealth.put(poke,100.0);
		}
		
		String charm = "Charmander";
		
		// Somewhere else Alakazam attacks Charmander for 12.5 damage
		double charmanderHealth = myTeamsHealth.get(charm);
		// Decrease charmander's health
		charmanderHealth -= 12.5;
		// Update the map with the new health value
		myTeamsHealth.put(charm, charmanderHealth);
		
		// One liner...not recommended
		myTeamsHealth.put("Charmander", myTeamsHealth.get("Charmander") - 12.5);
		
		for(Map.Entry<String,Double> healthEntry : myTeamsHealth.entrySet()) {
			// the getKey gets the name, getValue gets the current health
			System.out.println(healthEntry.getKey() + " " + healthEntry.getValue() + "/100");
		}
		
		
		
	}

}
