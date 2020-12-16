package com.techelevator;

public class BankAccount implements Accountable {

	//INSTANCE VARIABLES
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //CONSTRUCTORS
    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //GETTERS
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    //METHOD
    
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
    	//get balance of this account
    	int oldBalance = this.getBalance();
    	//perform withdrawal 
    	this.withdraw(transferAmount);
    	//check values are different for withdrawal to occur
    	if(this.getBalance() < oldBalance) {
    		//if withdrawal occurs
        	destinationAccount.deposit(transferAmount);	
    	
    	} return this.getBalance();
    	
    	}
    	
    	
    
  
    // Update the balance by using the DollarAmount.Plus method
    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    // Update the balance by using the DollarAmount.Minus method
    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }

}
