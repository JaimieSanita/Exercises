package com.techelevator.farm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class OldMacdonald {
	public static void main(String[] args) {

		// This will not work because farm animal is marked abstract
		//FarmAnimal animal = new FarmAnimal("Some animal", "whatever");
		
		// this works in both cases...POLYMORPHISM!!
		FarmAnimal anAnimal = new Pig();
		
		FarmAnimal[] animals = new FarmAnimal[] {new BarnCat(), new Cow(), new Chicken(), new Pig()};
		
		for(int i = 0; i < animals.length; i++) {
			FarmAnimal animal = animals[i];
			animal.setIsAsleep(i % 2 == 0);
		}
		
		
		List<Singable> singables = new ArrayList<Singable>();
		
		// List.addAll accepts another list as a parameter
		// Arrays.asList converts an array into a list
		singables.addAll(Arrays.asList(animals));
		
		// tractor wasn't part of our animals collection
		singables.add(new Tractor());

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}