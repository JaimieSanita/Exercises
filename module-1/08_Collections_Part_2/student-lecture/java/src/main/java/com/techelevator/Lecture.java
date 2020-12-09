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

		Map<String, Integer> inventory = new HashMap<String, Integer>(); // used to track inventory of current player

		Map<String, List<String>> players = new HashMap<String, List<String>>(); // similar to declaring List but only 1
																					// data type in list

		// load up inventory with .put() method with key,value that match data types
		// from declaration statement

		inventory.put("pokeball", 10);
		inventory.put("potion", 5);
		inventory.put("rare candy", 1);

		// replace an item
		inventory.put("pokeball", 15); // this will REPLACE ("pokeball",10) to ("pokeball",15); do NOT need to remove
										// before add

		// for comparison, let's make List for player

		List<String> ourPlayer = new ArrayList<String>();
		// add to ourPlayer list
		ourPlayer.add("Charmander");
		ourPlayer.add("Bulbasaur");
		ourPlayer.add("Squirtle");

		// put the player into the player Map

		players.put("Ash", ourPlayer); // map players adding "Ash" as key, and List ourPlayer as List<String>

		System.out.println("We have " + inventory.get("pokeball") + " pokeballs"); // on Map .get() method takes KEY
																					// that I want to fetch value for
																					// therefore, if want # of potions,
																					// get("potion") to get 5

		// system will return NULL if .get() key that is not present
		System.out.println("We have " + inventory.get("untraball") + " untraballs");

		// better version & will not print null, just shows that "ultraball" does not
		// exist as key
		if (inventory.containsKey("ultraball")) {
			System.out.println("We have " + inventory.get("untraball") + " untraballs");

		}

		// will print all keys
		// created set of String variable inventoryKeys and setting equal to Keys of Map
		// inventory
		// reference to map and .keySet() method gets all keys out of Map inventory
		Set<String> inventoryKeys = inventory.keySet(); // Set means linear list without duplicates, duplicates now
														// impossible
		System.out.println(inventoryKeys);

		// looping over Key values and print each key and then going into inventory map
		// and get value associated with key and print
		for (String itemKey : inventoryKeys) {
			// get values matching keys from itemKey from inventory Map
			System.out.println(itemKey + " : " + inventory.get(itemKey));
		}

		// loop over items in Map
		// for each loop, can tell by colon
		// Map.Entry is one pair of items in Map
		// .entrySet() is method to pull all key-value pairs in Map inventory
		for (Map.Entry<String, Integer> inventoryItem : inventory.entrySet()) {
			// the item names are our Map keys
			String itemName = inventoryItem.getKey();
			// the Map values are our quantity
			int quantity = inventoryItem.getValue();
			System.out.println(itemName + " : " + quantity);
		}

		/**
		 * 
		 * Adding additional players
		 * 
		 */
		// declaring list of string called otherPlayer
		List<String> tempPlayer = null;

		// create new player by instantiating a new arraylist
		tempPlayer = new ArrayList<String>(); // point otherPlayer to new list

		tempPlayer.add("Pidgey"); // adding pidgey to new list otherPlayer

		// otherPlayer list is stored in the players Map
		players.put("Trainer Kid", tempPlayer); // adding <String>="Trainer Kid", <List> =otherPlayer to Map players

		// Map is now tracking "Trainer Kid" so set to null to clear
		tempPlayer = null;

		// assigning an existing variable to new reference value

		tempPlayer = new ArrayList<String>(); // setting to newArrayList creates new memory block to hold list
		// added items to new List otherPlayer
		tempPlayer.add("Gyarados");
		tempPlayer.add("Dragonite");
		tempPlayer.add("Alakazam");

		players.put("Gary", tempPlayer); // added String "Gary", List otherPlayer to players map

		tempPlayer = new ArrayList<String>(); // every time use NEW, make new memory block for other players
		tempPlayer.add("Pikachu");
		players.put("Professor Oak", tempPlayer);

		tempPlayer = null; // done using this list so set to null to protect list from getting more items
							// changed

		// printing two blank lines
		System.out.println("\n\n");
		// name , list of pokemon
		for (Map.Entry<String, List<String>> player : players.entrySet()) {
			// Print out the name of the character(map key)
			System.out.println("Roster for " + player.getKey() + " : "); // print key
			// get map value (list<string>) and store it in variable
			List<String> playerPokemon = player.getValue(); // made string list to hold pokemon
			// loop over all the pokemon for this player
			for (String pokemon : playerPokemon) {
				// print individual pokemon with a couple of tabs
				System.out.println("\t\t" + pokemon);
			}
			System.out.println();// for spacing

			/**
			 * 
			 * Write a "use a potion" potion in inventory
			 */
			// Get quantity out of our inventory
			// update quantity with a new value

			int currentQuantity = inventory.get("potion");

			// decrement value to consume 1 potion; subtract by one
			currentQuantity--;

			// put updated amount back into Map
			inventory.put("potion", currentQuantity);

			// make new map
			Map<String, Double> myTeamsHealth = new HashMap<String, Double>();
			// get the list of pokemon for ash
			List<String> ashPokemon = players.get("Ash");
			// put each pokemon into the health map and give it 100.0 health
			for (String poke : ashPokemon) {
				myTeamsHealth.put(poke , 100.0); // put .0 because double
			}

			// somewhere else alakazam attacks charmander for 12.5 damaage
			// get charmander original health
			double charmanderHealth = myTeamsHealth.get("Charmander");
			// decrease charmanders health
			charmanderHealth -= 12.5;
			// update map with new health value for charmander
			myTeamsHealth.put("Charmander", charmanderHealth);

			for (Map.Entry<String, Double> healthEntry : myTeamsHealth.entrySet()) {
				// the getKey gets the name and getValue gets current health
				System.out.println(healthEntry.getKey() + " " + healthEntry.getValue() + "/100");
			}

		}
	}
}
