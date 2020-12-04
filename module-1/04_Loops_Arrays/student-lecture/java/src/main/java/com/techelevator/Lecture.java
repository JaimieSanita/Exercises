package com.techelevator;

public class Lecture {

    /*
    1. Return the created array; example of static initialization because elements defined in array 
    */
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 };
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        int lastIndex = portNumbers.length -1;
        //the lastIndex is length of array - 1
        //can use variables that are int because declared 
        return portNumbers[lastIndex];
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {
    	if (passedInArray == null || passedInArray.length == 0) { //defensive coding; in case first element is null or in case last element is 0, we return 0 instead of error
    		return 0;
    	}
        return passedInArray[0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
    	int lastIndex = (passedInArray.length - 1);
        return passedInArray[lastIndex];
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
       /to return a variable, the variable must be defined with coding block, pay attention to curly braces {} 
        * set needed variable (result) to placeholder value (0) because value redefined within inner code block
    */
    public int returnVariableFromBlock(int number) {
    	int result = 0;

        { // A new block with scoped variables

            result = number * 5;

        } // the result variable disappears here

        return result; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
 
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier; // equivalent to result = result * multiplier
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;
        }

        return counter == 4; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
        Every other count = change count to: i += 2
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i +=2) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }


		public void unOh () {
			if(5>1); {						//this will not print because of the ; behind the if statement. Putting ; after if statements effectively removes block of codes from statment and conditional
				System.out.println("Yep, five is bigger than one");
			}
		}
}