package com.techelevator;

public class StringBits {

	/*
	 * Given a string, return a new string made of every other char starting with
	 * the first, so "Hello" yields "Hlo". 
	 * GetBits("Hello") → "Hlo" 
	 * GetBits("Hi") → "H" 
	 * GetBits("Heeololeo") → "Hello"
	 */
	public String getBits(String str) {
		String result = "";
		//if string not null
		if (str != null) {
			//loop through
			for (int i = 0; i < str.length(); i++) {
				//and if even(everyother)
				if (i % 2 == 0) {
					//add to new string
					result += str.charAt(i);
				}
			}
		}
		return result;
	}
}
