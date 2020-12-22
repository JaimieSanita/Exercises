package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

	/*
	 * Given an array of strings, return a Dictionary<string, int> with a key for
	 * each different string, with the value the number of times that string appears
	 * in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	 * getCount([]) → {}
	 * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> getCount(String[] words) {
		//map created called output
		Map<String, Integer> output = new HashMap<>();
		//if string array not null
		if (words != null) {
			//loop through string array with word
			for (String word : words) {
				//if the map does not contain a key containing the provided key, return key, 1; SHOULD BE 0?
				if (!output.containsKey(word)) {
					output.put(word, 1);
				} else {
					//if map key does contain key provided, add key  with value +1
					output.put(word, output.get(word) + 1);
				}
			}
		}

		return output;
	}
}