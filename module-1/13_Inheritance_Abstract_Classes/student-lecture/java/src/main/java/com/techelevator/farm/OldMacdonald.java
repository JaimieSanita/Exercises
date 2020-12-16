package com.techelevator.farm;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class OldMacdonald {
	public static void main(String[] args) {
		//this constrcutor doesn't compile because FarmAnimal is abstract class
		//FarmAnimal animal =  new FarmAnimal("Some animal", "Whatever");
		
		//But can use FarmAnimal as variable
		//this works in both cases...Polymorphism

		FarmAnimal anAnimal = new Pig();
		
		//can use FarmAnimal as an array because making new array, not new FarmAnimal class
		FarmAnimal[] animals = new FarmAnimal[] {new BarnCat(), new Cow(), new Chicken(), new Pig()};

		//if i want to put animals to sleep, for loop through FarmAnimal[] array called animals
		for(int i = 0; i < animals.length; i++) {
			FarmAnimal animal = animals[i]; //create FarmAnimal called animal that takes value of animals values 
			animal.setisAsleep(i % 2 == 0); //sets everyother animal to asleep; remember isAsleep is boolean
		}
		
		List<Singable> singables = new ArrayList<Singable>();
		singables.addAll(Arrays.asList(animals)); //use Lists have .addAll method that accepts another list as a parameter
													//Arrays.asList turns array into List
		singables.add(new Tractor()); //add new tractor after the fact because tractor is singable but not part of the animals array
		
	

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