package com.techelevator.farm;

import java.util.List;
import java.util.ArrayList;

public class OldMacdonald {
	public static void main(String[] args) {
		//not polymorphism because same type
		Chicken chicken = new Chicken();
		
		//polymorphism; inheritance based, Cow() inherits FarmAnimal
		FarmAnimal cw = new Cow();
		
		Pig pig = new Pig();
		
		//polymorphism; inheritance-based; substituting chicken and pig for FarmAnimal
		FarmAnimal[] farmAnimals= new FarmAnimal[] {cw, chicken, pig};
		
		
		//static array initializer
		//FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig() };

		//Examples of Polymorphism: 
		
		List<Singable> singables = new ArrayList<Singable>();
		//in java, a list is an interface; ArrayList is a data structure that implements list
		
		//for each loop to add farm animals to singable list
		for(FarmAnimal animal: farmAnimals) {
			singables.add(animal); //interface based polymorphism; putting FarmAnimal in where Singable
		}
		
		Tractor tractor = new Tractor(); //variable declaration not polymorphism because same type Tractor
		singables.add(tractor); //interface based polymorphism because putting Tractor where Singable 
		//can add farmAnimals and tractor to same list because share Singables functionality
		
		//for each loop, looping through singables List<Singable>
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
		 * 
		 * Sellable Polymorphism
		 * 
		 */
		System.out.println("\n\n");
		
		Sellable[] sellables = new Sellable[] {chicken, new Egg(), pig}; //static array for Sellable
		
		for(Sellable forSale : sellables) {
			System.out.println("Step right up and get your: " + forSale.getName());
			System.out.println("Only: $" + forSale.getPrice());
			System.out.println("Make yourself some: " + forSale.getMeal());
		}
		
	}
}