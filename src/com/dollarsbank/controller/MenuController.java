package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.model.Account;
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
		do {
			PrintUtility.boxedPrint("WELCOME Customer!!!");
			int input = InputUtility.getNumberInput(sc, options);
			switch(input) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("Not implemented yet.");
				break;
			case 6:
				loggedIn = false;
				System.out.println("Successfully logged out.");
				break;
			default:
				System.out.println("Error: Recieved invalid input");
			}
			System.out.println();
		} while (loggedIn);
	}
	
}
