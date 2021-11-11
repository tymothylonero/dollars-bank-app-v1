package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.utility.AccountUtility;
import com.dollarsbank.utility.InputUtility;
import com.dollarsbank.utility.PrintUtility;

public class MenuController {
	
	private static String[] options = {
			"Deposit Amount", 
			"Withdraw Amount", 
			"Funds Transfer", 
			"View 5 Recent Transactions", 
			"Display Customer Information", 
			"Sign Out"
		};

	public static void mainMenu(Scanner sc, Account user) {
		boolean loggedIn = true;
		
		// Run the main menu
		do {
			PrintUtility.boxedPrint("WELCOME Customer!!!");
			int input = InputUtility.getNumberInput(sc, options);
			switch(input) {
			// Deposit
			case 1:
				user.deposit(sc, "Enter an amount to deposit:");
				break;
			// Withdraw
			case 2:
				user.withdraw(sc, "Enter an amount to withdraw:");
				break;
			// Transfer funds to another account
			case 3:
				AccountUtility.fundsTransfer(sc, user);
				break;
			// List the five most recent transactions
			case 4:
				PrintUtility.boxedPrint("5 Recent Transactions");
				System.out.print(user.fiveTransactions());
				break;
			// List the information on the account
			case 5:
				PrintUtility.boxedPrint("Account Information");
				System.out.println(user);
				break;
			// Log out of the account
			case 6:
				loggedIn = false;
				PrintUtility.printColor("Successfully logged out.", "lime");
				break;
			default:
				PrintUtility.printColor("Error: Recieved invalid input.", "red");
			}
			System.out.println();
		} while (loggedIn);
	}
	
}
