package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


import com.techelevator.pokemon.*;


public class CsvLoader {

	private File inputFile;
	
	public CsvLoader(File inputFile) {
		this.inputFile = inputFile;
	}
	
	
	// NOTE this changed to protected here to facilitate testing!
	protected Pokemon convertLineIntoPokemon(String line) {
		String[] components = line.split(",");

		if(components.length != 2) {
			return null;
		}
		
		String pokemonType = components[0].trim();
		String pokemonName = components[1].trim();
		
		if(pokemonType.toLowerCase().equals("bulbasaur")) {
			return new Bulbasaur();
		} else if(pokemonType.toLowerCase().equals("rapidash")) {
			return new Rapidash(pokemonName);
		} else if (pokemonType.toLowerCase().equals("eevee")){
			return new Eevee(pokemonName);
		} else if (pokemonType.toLowerCase().equals("snorlax")){
			return new Snorlax();
		} else {
			return null;
		}
		//        determine the right class Eevee, bulbasaur, etc
		//        instantiate the class and set the name
	}
	
	public Map<Integer, Pokemon> loadPokedex() {
		// make a new map
		Map<Integer, Pokemon> pokedex = new HashMap<Integer,Pokemon>();
		
		// read the file
		try(Scanner fileScanner = new Scanner(this.inputFile)){
			// for each item in the file
			int lineNumber = 1;
			while(fileScanner.hasNextLine()) {
				// get the line from the scanner
				String line = fileScanner.nextLine();
				Pokemon p = convertLineIntoPokemon(line);
				//        add the object into my map at the appropriate index
				if(p != null) {
					pokedex.put(p.getPokedexIndex(), p);
				}
				
				lineNumber++;
			}	
		} catch (FileNotFoundException fnf) {
			return null;
		}
		
		return pokedex;
	}
}
