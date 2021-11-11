package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.dollarsbank.controller.LoginController;
import com.dollarsbank.controller.MenuController;
import com.dollarsbank.model.Account;
import com.dollarsbank.utility.FileUtility;
import com.dollarsbank.utility.InputUtility;
import com.dollarsbank.utility.PrintUtility;

public class DollarsBankApplication {
	
	public static Scanner sc;
	public static ArrayList<Account> accountList;
	public static Account currentUser;
	private static boolean usingColor = false;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		boolean running = true;
		
		// Get color confirmation
		System.out.println("Run DOLLARSBANK with colored output? Y/N");
		usingColor = InputUtility.yesNo(sc);
		
		// Load accounts
		accountList = FileUtility.load();
		
		// Run the login menu
		do {
			PrintUtility.boxedPrint("DOLLARSBANK Welcomes You!");
			int input = InputUtility.getNumberInput(sc, new String[] {"Create New Account", "Login", "Exit"});
			switch(input) {
			// Create an account
			case 1:
				currentUser = LoginController.createAccount(sc, accountList);
				accountList.add(currentUser);
				MenuController.mainMenu(sc, currentUser);
				break;
			// Log into an existing account
			case 2:
				currentUser = LoginController.login(sc, accountList);
				if(currentUser != null)
					MenuController.mainMenu(sc, currentUser);
				break;
			// Exit the application
			case 3:
				running = false;
				break;
			default:
				PrintUtility.printColor("Error: Recieved invalid input.", "red");
			}
		} while(running);
		
		if(FileUtility.save(accountList))
			PrintUtility.printColor("Goodbye!", "lime");

		sc.close();
	}
	
	public static boolean isUsingColor() {
		return usingColor;
	}
	
}