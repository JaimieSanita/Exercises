package com.techelevator;

public class HomeworkAssignment {
	
	//don't believe there are constants

	//instance variables
	private int possibleMarks;
	private int earnedMarks;
	private String submitterName;
	
	//getters
	public int getPossibleMarks() {
		return possibleMarks;
	}
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	
	public String getSubmitterName() {
		return submitterName;
	}
	
	//derived getter
	public String getLetterGrade() {
		int grade = (this.earnedMarks*100)/this.possibleMarks;
		if (grade >= 90) {
			return "A";
		} else if (grade >= 80 && grade <= 89) {
			return "B";
		} else if (grade >= 70 && grade <= 79) {
			return "C";
		} else if (grade >= 60 && grade <= 69) {
			return "D";
		} else {
			return "F";
		}
	}
	
	//Constructor
	public HomeworkAssignment(int possibleMarks, String submitterName) {
		//set parameters
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}

	
	/*
 Instance variables

| Attribute | Data Type | Get | Set | Description | | ----------------------- | --------- | --- | --- | ----------------------------------------------------------------------- 
earnedMarks | int | X | X | The total number of correct marks submitter received on the assignment. | | 
possibleMarks | int | X | | The number of possible marks on the assignment. | | 
submitterName | string | X | | The submitter's name for the assignment. | |
letterGrade(derived)| string | X | | The letter grade for the assignment. |

Notes
•letterGrade is a derived attribute that's calculated using earnedMarks and possibleMarks:
•For 90% or greater, it returns "A"
•For 80-89%, it returns "B"
•For 70-79%, it returns "C"
•For 60-69%, it returns "D"
•Otherwise, it returns "F"
•_hint_: possibleMarks and earnedMarks are ints. What happens when a smaller integer is divided by a larger integer?

	 */
}
