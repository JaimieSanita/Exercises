package com.techelevator;

public class Employee {
	
	//instance variable
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String department;
	private double annualSalary;
	
	//getters
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	//setters
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	//derived fullName get
	
	public String getFullName() {
		String name = "";
		name = this.lastName + ", " + this.firstName;
		return name;
	}

	//constructor
	
	public Employee(int employeeID, String firstName, String lastName, double annualSalary) {
		//set parameters
		this.employeeId = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
	}
	
	//method
	
	public void raiseSalary(double percent) {
		double newSalary = annualSalary + ((percent * 0.01) * annualSalary);
		this.annualSalary = newSalary;
	}
}
	/*
	 * 
Instance variables

| Attribute | Data Type | Get | Set | Description | | -------------------- | --------- | --- | --- | ----------------------------- | | 
employeeId | int | X | | The employee ID. | | 
firstName | string | X | | The employee's first name. | | 

lastName | string | X | X | The employee's last name. | | 
department | string | X | X | The employee's department. | | 

annualSalary | double | X | | The employee's annual salary. |

fullName(derived)| string | X | | The employee's full name. | | 

Notes
•fullName is a derived attribute that returns lastName, firstName.

Constructor

Create a constructor for this class that accepts four parameters: int employeeId, String firstName, String lastName, and double salary. 
Use these parameters to set the instance variables of the class.

Methods

Create a method called raiseSalary that accepts a double called percent and returns void. 
The method increases the current annual salary by the percentage provided. For example, 5.5 represents 5.5%.

	 */

