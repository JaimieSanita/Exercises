package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		int[] arr = new int[5];
		
		// NOTE: List is the generic type, also called an interface
		// we will almost always use an ArrayList
		//List<String> otherList = new LinkedList<String>();
		
		List<String> names = new ArrayList<String>();
		
		names.add("Frodo");
		names.add("Sam");
		names.add("Bilbo");
		names.add("Merry");
		names.add("Aragorn");
		names.add("Gandalf");
		names.add("Legolas");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		int listSize = names.size();
		
		// Note that lists have a shorthand print that looks like this
		// for now, write the loop
		// System.out.println("Names: " + names);
		
		for(int i = 0; i < listSize; i++) {
			String theName = names.get(i);
			System.out.println(theName);
		}
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Gandalf");
		
		for(int i = 0; i < names.size() ; i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2,"Gimli");
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(6);
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if(names.contains("Gandalf")) {
			System.out.println("Yur a wizard Harry");
		}else {
			System.out.println("Not a magical drop of blood in ya");
		}
		
		
		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		
		int indexOfGandalf = names.indexOf("Gandalf");
		
		
		System.out.println("Gandalf is at position: " + indexOfGandalf);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArr = new String[names.size()];
		
		for(int i = 0; i < names.size(); i++) {
			// notice that only arrays can have values set using the assignment
			// operator (=)
			namesArr[i] = names.get(i);
		}
		
		System.out.println("####################");
		System.out.println("Arrays can be turned into lists");
		System.out.println("####################");

		List<String> names2 = new ArrayList<String>();
		
		for(int i = 0; i < namesArr.length ; i++) {
			//Add items to a list by using add
			names2.add(namesArr[i]);
		}
		
		
		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		
		//Note this changes the order of the underlying list
		Collections.sort(names);
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		
		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names); 
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		//To sort in reverse alphabetical order
		Collections.sort(names);
		Collections.reverse(names);
		
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		
		System.out.println("####################");
		System.out.println("       Original FOR Loop");
		System.out.println("####################");
		//Typical for pattern
		// for(<declaration> ; <conditional> ; <iteration/increment>) 
		
		for(int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			System.out.println(name);
		}
		
		
		System.out.println("####################");
		System.out.println("       PRINT WITH FOREACH");
		System.out.println("####################");
		
		// Java also has a foreach loop that looks like this
		// for( <declaration> : <collection>)
		
		// for each string name in the names list do { } 
		// WARNING - You can't change the list while you're using a for each
		// SO no remove/add, etc
		
		for(String name : names) {
			String excited = name + "!";
			System.out.println(excited);
		}
		
	}
}
