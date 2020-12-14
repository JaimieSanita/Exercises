package com.techelevator;

public class SavingsAccount extends BankAccount {
	
	//constructors
	
	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
		}
	
	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}
	
	
	//If the current balance is less than $150 when a withdrawal is made, 
	//an additional $2 service charge is withdrawn from the account.  
	
	//If a withdrawal is requested for more than the current balance, 
	//the withdrawal fails and the balance remains the same. 
	//No fees are incurred. |
	@Override
	public int withdraw(int amountToWithdraw) {
		int balanceAfterWithdrawal = getBalance() - amountToWithdraw;
		//most exclusive; if withdrawal > current balance
		if (balanceAfterWithdrawal > getBalance() - 2) {
			//return balance, no fees
			return getBalance();
			//regular withdrawal
		} else if (balanceAfterWithdrawal < 150) {
			super.withdraw(amountToWithdraw);
			return super.withdraw(2);
		} else {
			return super.withdraw(amountToWithdraw);
			
		}
	}

}
