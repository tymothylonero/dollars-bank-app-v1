package com.dollarsbank.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.utility.AccountUtility;
import com.dollarsbank.utility.PrintUtility;

public class LoginController {

	public static Account login(Scanner sc, List<Account> accounts) {
		PrintUtility.boxedPrint("Enter Login Details");
		
		boolean loggedIn = false;
		int loginAttempts = 5;
		Account found = null;
		
		do{
			
			System.out.println("User ID:");
			String accountID = sc.nextLine();

			System.out.println("Password:");
			String password = sc.nextLine();
			
			loginAttempts--;
			
			found = AccountUtility.findAccountWithCredentials(accounts, accountID, password);
			if(found != null)
				loggedIn = true;
			else if (loginAttempts == 0)
				System.out.println("Failed to login. Returning to main menu...");
			else if (loginAttempts == 1)
				System.out.println("Invalid credentials. Try again. (" + loginAttempts + " attempt remaining)");
			else
				System.out.println("Invalid credentials. Try again. (" + loginAttempts + " attempts remaining)");
			
		} while(!loggedIn && loginAttempts > 0);
		
		return found;
	}
	
	public static Account createAccount(Scanner sc, List<Account> accounts) {
		PrintUtility.boxedPrint("Enter Details for New Account");
		
		System.out.println("Customer Name:");
		String name = sc.nextLine();

		System.out.println("Customer Address:");
		String address = sc.nextLine();

		System.out.println("Customer Contact Number:");
		String phoneNumber = sc.nextLine();

		System.out.println("User ID:");
		String accountID = sc.nextLine();
		
		System.out.println("Password:");
		String password = sc.nextLine();

		System.out.println("Initial Deposit Amount:");
		double balance = Double.parseDouble(sc.nextLine());
		
		return new Account(accountID, password, name, address, phoneNumber, LocalDateTime.now(), balance);
	}
	
}
