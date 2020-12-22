package com.techelevator;

public class NonStart {

    /*
     Given 2 strings, return their concatenation, except omit the first char of each. The strings will
     be at least length 1.
     GetPartialString("Hello", "There") → "ellohere"
     GetPartialString("java", "code") → "avaode"
     GetPartialString("shotl", "java") → "hotlava"
     */
    public String getPartialString(String a, String b) {
    	//if A is empty or 0, return B minus first letter
        if (a.length() == 0) {
            return b.substring(1);
        //if B is empty or 0, return A minus first letter
        } else if (b.length() == 0) {
            return a.substring(1);
        } else {
        	//if A & B are not empty or 0, A+B minus first letters
            return a.substring(1) + b.substring(1);
        }
    }
}
