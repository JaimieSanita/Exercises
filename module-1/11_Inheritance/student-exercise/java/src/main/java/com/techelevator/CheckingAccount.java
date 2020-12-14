package com.techelevator;

public class CheckingAccount extends BankAccount {
	
	//make exact constructors
	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
		}
	
	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}
	
	//If the balance falls below $0.00 and is less than -$100.00, 
	//a $10.00 overdraft fee is also charged against the account. 
	
	//Checking account can't be overdrawn by $100.00 or more. 
	//If a withdrawal request leaves the account $100 or more overdrawn, 
	//it fails and the balance remains the same. 
	
	//For example, if the current balance is -$89.00, 
	//and the amount to withdraw is $10.00, 
	//the resulting balance is -$99.00. 
	//The withdraw is permitted since the new balance is less than -$100.00. 
	//The $10.00 overdraft fee is then charged against the account, 
	//resulting in a final balance of -$109.00.<br><br>
	
	//A withdrawal of $11.00 in the same situation fails
	//because the new balance is -$100.00 which is equal to ***but not less than*** the limit of -$100.00. 
	
	//super.withdraw(10);
	@Override
	public int withdraw(int amountToWithdraw) {
		int balanceAfterWithdrawal = getBalance() - amountToWithdraw;
				//most exclusive, if balance after withdrawal is more than -100
			if(balanceAfterWithdrawal <= -100) {
				//no change
			return getBalance();
			//if not overdrawn by more than 100, do regular withdrawal
			} else if (balanceAfterWithdrawal > -100 && balanceAfterWithdrawal >= 0) {
				return super.withdraw(amountToWithdraw);
				//penalizing case; two step: withdraw + fee
			} else {
				 super.withdraw(amountToWithdraw);
				 return super.withdraw(10);
			}
		
	}
}

