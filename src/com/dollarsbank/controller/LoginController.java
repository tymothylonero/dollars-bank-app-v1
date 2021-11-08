package com.dollarsbank.controller;

import java.util.List;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.utility.PrintUtility;

public class LoginController {

	public static Account login(Scanner sc, List<Account> accounts) {
		PrintUtility.boxedPrint("Enter Login Details");
		
		System.out.println("User ID:");
		String accountID = sc.nextLine();

		System.out.println("Password:");
		String password = sc.nextLine();
		
		return new Account();
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
		
		return new Account();
	}
	
}
