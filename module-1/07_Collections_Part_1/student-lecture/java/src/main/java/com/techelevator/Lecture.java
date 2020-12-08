package com.techelevator;		//defines name space

import java.util.ArrayList;		//allows import of java.util name space and get ArrayList class and bring into my local space;
import java.util.Collections;	//third party library and needs to be at top of code;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> names = new ArrayList<String>();	//List is the generic type; also called an interface
		names.add("Frodo");								//mostly will use ArrayList; other Lists out there
		names.add("Sam");								//add new items to end of List by default
		names.add("Bilbo");								//did not need to specify size, just add items
		names.add("Mary");
		names.add("Aragon");
		names.add("Gandalf");
		names.add("Legolas");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		
		int listSize = names.size();				//() indicate method
		for (int i=0; i < listSize; i++) {
			System.out.println(names.get(i));		//print i but need to get string first
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Gandolf");
		for ( int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2, "Gimli"); //will add "Gimli" to index 2 and will move other items to accommodate;
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(6);
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		if (names.contains("Gandolf")) {
			System.out.println("You're a wizard Harry");
		} else {
			System.out.println("NOt a magical drop of blood in you");
		}


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfGandolf = names.indexOf("Gandolf");
		
		System.out.println("Gandolf at position: " + indexOfGandolf);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArr = new String[names.size()]; //declared array with same number of spots as list currently has
		for( int i = 0; i < names.size(); i++) {	//notice that only arrays can have values set using the assignment operation (=)
			namesArr[i] = names.get(i); 			//assigning namesArr[i] the values of list of string called names using get() method
		}	
		
		System.out.println("####################");
		System.out.println("Arrays can be turned into Lists");
		System.out.println("####################");
		
		List<String> names2 = new ArrayList<String>();
		for (int i = 0; i < namesArr.length; i++) {	//use .length for array, not .size()
			names2.add(namesArr[i]); 				//add items to a list by using add
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names); 				//note that this changes the order of the underlying list
												//default sort organizes strings alphabetically and ints by number order
		for (int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names); 		//do not need to sort before reversing
		
		for (int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		//to sort in reverse alpha order
		
		Collections.sort(names);
		Collections.reverse(names);
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		//Remember: for loop syntax
		//for (<declaration> ; <conditional> ; <iteration>)
		
		System.out.println("####################");
		System.out.println("       Original FOR Loop");
		System.out.println("####################");
		System.out.println();
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));		//i is only used to get items out
		} System.out.println();
		
		System.out.println("####################");
		System.out.println("       PRINT WITH FOREACH");
		System.out.println("####################");
		System.out.println();
		
		//Java has a foreach loop syntax
		//Note : and no ;
		// for (<declaration> : <collection>)
		//WARNING: can not change list while using foreach; can't use remove/add/etc.
		//shorthand for copying elements or printing everything
		for (String name : names) {		//use foreach loops when only care for VALUE, not POSITION
			String excited = name + "!";
			System.out.println(excited);	//creates new String called name that will go through each string in list names & perform 
										//{ what's inside braces}
		}
	}
}
