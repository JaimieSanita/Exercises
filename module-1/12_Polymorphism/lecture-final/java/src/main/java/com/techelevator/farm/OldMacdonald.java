package com.techelevator.farm;

import java.util.List;
import java.util.ArrayList;

public class OldMacdonald {
	public static void main(String[] args) {

		Chicken chicken = new Chicken();
		
		// EXAMPLES OF POLYMORPHISM
		FarmAnimal cw = new Cow(); // inheritance based polymorphism
		
		Pig pig = new Pig();
		
		FarmAnimal[] farmAnimals = new FarmAnimal[] { cw, chicken, pig }; // inheritance based polymorphism
		

		
		List<Singable> singables = new ArrayList<Singable>(); // interface based polymorphism List interface, ArrayList class
		
		// for each loop to add the farm animals to the singable list
		for(FarmAnimal animal : farmAnimals) {
			singables.add(animal); // interface based polymorphism Singable <- FarmAnimal
		}
		
		Tractor tractor = new Tractor(); // NOT Polymorphism
		
		singables.add(tractor); // interface based polymorphism Singable <- Tractor
		

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		
		
		/**
		 * Sellable polymorphism
		 * 
		 */
		
		System.out.println("\n\n");
		
		Sellable[] sellables = new Sellable[] {chicken,new Egg(), pig };
		
		for (Sellable forSale : sellables) {
			System.out.println("Step right up and get your: " + forSale.getName());
			System.out.println("Only: $"+ forSale.getPrice());
			System.out.println("Make yourself some: " + forSale.getMeal());
		}
		
	}
}