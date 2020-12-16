package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	
			//instance variable
			private String name;
			private String address;
			private String phoneNumber;
			private List<Accountable> accounts = new ArrayList<Accountable>();  //Returns the customer's list of Accountables as an array.
			
			//getters
			
			public String getName() {
				return name;
			}
			
			public String getAddress() {
				return address;
			}
			
			public String getPhoneNumber() {
				return phoneNumber;
			}
			
			public Accountable[] getAccounts() {
				  return accounts.toArray(new Accountable[accounts.size()]);
				}
			
			//setters
			
			public void setName(String name) {
				this.name = name;
			}
			
			public void setAddress(String address) {
				this.address = address;
			}
			
			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}
			
			
			//Method; Adds newAccount to the customer's list of accounts.
			//Note: Even though the accounts getter returns an array, you don't have to store the accounts in the BankCustomer as an array. 
			//Since you need to add accounts whenever the addAccount() method is called, 
			//you'll want to use a different data structure in the class to store the accounts that's like an array, 
			//but can be added to at any time.
			
			//public method called addAccount that has NO return. Use Interface newAccount which is Accountable as resource 
			public void addAccount(Accountable newAccount) {
				accounts.add(newAccount);
				//store accounts in list
				//add newAccount
			}
			
			//Customers whose combined account balances (credits minus debts) are at least $25,000 are considered VIP customers and 
			//receive special privileges.
			
			//because "combined acct balance" need to SUM; create variable
			//to access each account use loop

			//Add a method called isVip to the BankCustomer class that returns true if the sum of all accounts belonging to the customer 
			//is at least $25,000 and false otherwise.

			//Once the BankCustomerTests unit test passes, this section is complete.
			
			public boolean isVip() {
				//create sum variable
				int accountCombined = 0;
				//loop through accounts and get balance
				for(Accountable account: this.getAccounts()) { //for each account in this.getAccounts(), the new Accountable called account
					//add balance to accountCombined variable
					accountCombined += account.getBalance(); //get the balance and store in sum variable
				} if (accountCombined >= 25000) {
					return true;
				} else {
					return false;
				}
			
				
			}

}
