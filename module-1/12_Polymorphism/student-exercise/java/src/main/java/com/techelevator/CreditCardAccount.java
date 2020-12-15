package com.techelevator;

public class CreditCardAccount implements Accountable{

	@Override
	public int getBalance() {
		
		return this.debt;
	}
	//instance variables
	
	private String accountHolder;
	private String accountNumber;
	private int debt;
	
	//getters
	
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public int getDebt() { //Returns the amount the customer owes.
		return -debt;
	}
	
	//constructor; A new credit card account requires an account holder name and account number. The debt defaults to a 0 dollar balance.
	public CreditCardAccount(String accountHolder, String accountNumber) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
	}
	
	//method
	//Removes amountToPay from the amount owed and returns the new total amount owed.
	public int pay(int amountToPay) {
		this.debt += amountToPay;
		return debt;
	}
	
	//Adds amountToCharge to the amount owed, and returns the new total amount owed.
	public int charge(int amountToCharge) {
		this.debt -= amountToCharge;
		return debt;
	} 

}
