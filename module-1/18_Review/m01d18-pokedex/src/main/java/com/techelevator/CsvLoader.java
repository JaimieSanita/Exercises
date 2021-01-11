package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import com.techelevator.pokemon.Pokemon; //imported from own code
import com.techelevator.pokemon.*; //only use * if importing ALL classes within package

public class CsvLoader {
	// CONSTANTS
	private File inputFile;

	// CONSTRUCTOR
	public CsvLoader(File inputFile) {
		this.inputFile = inputFile;
	}

	// METHOD
	
	private Pokemon convertLineIntoPokemon(String line) { //because csv file has class & name on one line separated by comma, need to split
		String[] components = line.split(","); //splits and sets each item as element in string array
		
		if(components.length != 2) { //because now an array, and there should be two elements thus length 2
			return null;
		}
		
		String pokemonType = components[0].trim(); //.trim removes white space at beginning or end of string
		String pokemonName = components[1].trim();
		
		if(pokemonType.toLowerCase().equals("bulbasaur")) {
			return new Bulbasaur(); //creating new class instance if it appears in file
		} else if (pokemonType.toLowerCase().contentEquals("rapidash")) {
			return new Rapidash(pokemonName);
		}else if (pokemonType.toLowerCase().equals("eevee")) {
			return new Eevee(pokemonName);
		}else if (pokemonType.toLowerCase().equals("snorlax")) {
			return new Snorlax();
		} else {
			return null;
		}
	}
	
	public Map<Integer, Pokemon> loadPokeDex() { // import Pokemon b/c in different package

		// make new map

		Map<Integer, Pokemon> pokeDex = new HashMap<Integer, Pokemon>();

		// read file with TRY RESOURCE BLOCK (how to open,read,write to file)

		try (Scanner fileScanner = new Scanner(this.inputFile)) { 
			// for each item in file
			while(fileScanner.hasNextLine()) {
				//get line from scanner
				String line = fileScanner.nextLine();
				// determine correct class(eevee, bulbasaur); DONE IN CONVERTLINETINTOPOKEMON METHOD
				// instantiate the class & set name
				Pokemon p = convertLineIntoPokemon(line);
				
				// add object into map at appropriate index
				if(p !=null) {
					pokeDex.put(p.getPokeDexIndex(), p); //p is the pokemonType
				}
			}
			
			

		} catch (FileNotFoundException e) {
			return null;
		}

		return pokeDex;
	}

}
