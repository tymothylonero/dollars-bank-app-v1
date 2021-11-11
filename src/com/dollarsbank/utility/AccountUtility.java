package com.dollarsbank.utility;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.application.DollarsBankApplication;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Transaction;

public class AccountUtility {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static Account findAccountWithCredentials(List<Account> accounts, String accountID, String password) {
		
		for(Account a : accounts) {
			if( accountID.equals(a.getAccountID()) && password.equals(a.getPassword()))
				return a;
		}
		return null;
	}
	
	public static Account findAccountID(List<Account> accounts, String accountID) {
		
		for(Account a : accounts) {
			if( accountID.equals(a.getAccountID()) )
				return a;
		}
		return null;
	}
	
	public static boolean otherAccountsExist(String accountID) {
		for (Account a : DollarsBankApplication.accountList) {
			if(!accountID.equals(a.getAccountID()))
				return true;
		}
		return false;
	}
	
	public static void fundsTransfer(Scanner sc, Account user) {
		
		if(user.getBalance() <= 0) {
			PrintUtility.printColor("Cannot transfer from an account with no money!", "red");
			return;
		}
		
		if(!otherAccountsExist(user.getAccountID())) {
			PrintUtility.printColor("Cannot transfer when no other users exist!", "red");
			return;
		}
		
		PrintUtility.printColor("Please enter an account ID to transfer to:", "green");
		String input = sc.nextLine();
		
		if(input.equals(user.getAccountID())) {
			PrintUtility.printColor("You cannot transfer to your own account!", "red");
			return;
		}
		
		boolean found = false;
		Account transferToAccount = null;
		for (Account a : DollarsBankApplication.accountList) {
			if(input.equals(a.getAccountID())) {
				found = true;
				transferToAccount = a;
			}
		}
		
		if(found)
			completeTransfer(sc, user, transferToAccount);
		else
			PrintUtility.printColor("Error: Could not find an account with ID '" + input + "'.", "red");
		
		return;
	}
	
	private static void completeTransfer(Scanner sc, Account from, Account to) {
		
		df.setRoundingMode(RoundingMode.DOWN);
		
		PrintUtility.printColor("Enter an amount to transfer to " + to.getName() + ":", "green");
		double amount = InputUtility.getPositiveDoubleNonZero(sc, "Transfer");
		amount = Double.parseDouble(df.format(amount));
		if(amount > from.getBalance()) {
			PrintUtility.printColor("Cannot transfer more than what is in your account!", "red");
			return;
		}
		PrintUtility.printColor("Enter a description for this transfer:", "green");
		String description = sc.nextLine();
		
		LocalDateTime now = LocalDateTime.now();
		from.getTransactions().add(0, new Transaction("Funds Transfer", description, (amount * -1), from.modifyBalance(amount * -1), now));
		to.getTransactions().add(0, new Transaction("Funds Transfer", description, (amount), to.modifyBalance(amount), now));
		PrintUtility.printColor("Successfully transfered $" + df.format(amount) + " to " + to.getName() + ".", "lime");
	}

}