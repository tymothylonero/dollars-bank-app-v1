package com.dollarsbank.application;

import java.util.List;
import java.util.Scanner;

import com.dollarsbank.controller.LoginController;
import com.dollarsbank.controller.MenuController;
import com.dollarsbank.model.Account;
import com.dollarsbank.utility.InputUtility;
import com.dollarsbank.utility.PrintUtility;

public class DollarsBankApplication {
	
	public static Scanner sc;
	public static List<Account> accountList;
	public static Account user;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		boolean running = true;
		do {
			PrintUtility.boxedPrint("DOLLARSBANK Welcomes You!");
			int input = InputUtility.getNumberInput(sc, new String[] {"Create New Account", "Login", "Exit"});
			switch(input) {
			case 1:
				user = LoginController.createAccount(sc, accountList);
				MenuController.mainMenu(sc, user);
				break;
			case 2:
				user = LoginController.login(sc, accountList);
				MenuController.mainMenu(sc, user);
				break;
			case 3:
				running = false;
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Error: Recieved invalid input");
			}
		} while(running);

		sc.close();
	}
	
}