package com.techelevator;

public class BankAccount {
	
	//instance variables
	
	private String accountHolderName;
	
	private String accountNumber;
	
	private int balance;
	
	//getters
	
	public String getAccountHolderName() {
		return this.accountHolderName;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public int getBalance() {
		return this.balance;
	}
	//constructors
	
	public BankAccount(String accountHolderName, String accountNumber) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = 0;
		}
	
	public BankAccount(String accountHolderName, String accountNumber, int balance) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	//methods
	
	//adds amountToDeposit to current balance
	//returns new balance of bank account
	public int deposit(int amountToDeposit) {
		this.balance = amountToDeposit + getBalance();
		return this.balance;
	}
	
	//subtracts amountToWithdraw from current balance
	//returns new balance of account
	public int withdraw(int amountToWithdraw) {
		this.balance = getBalance() - amountToWithdraw;
		return this.balance;
	}
		
	

}
