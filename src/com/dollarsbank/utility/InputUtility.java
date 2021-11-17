package com.dollarsbank.utility;

import java.util.Scanner;

public class InputUtility {
	
	public static int getNumberInput(Scanner sc, String[] options) {
		// Print the options with numbers
		for(int idx = 0; idx < options.length; idx++)
			System.out.println((idx + 1) + ". " + options[idx]);
		System.out.println();
		
		// Get valid user input
		int input = 0;
		boolean valid = false;
		do {
			PrintUtility.printColor("Please enter your selection:", "green");
			
			try {
				input = Integer.parseInt(sc.nextLine());
				if(input > 0 && input <= options.length)
					valid = true;
				else
					PrintUtility.printColor(input + " is not a valid selection.", "red");
				
			// Input that is not an integer
			} catch (NumberFormatException e) {
				PrintUtility.printColor("That is not an integer!", "red");
			}
			
		} while(!valid);
		return input;
	}
	
	public static double getValidDouble(Scanner sc) {
		
		boolean valid = false;
		double value = 0;
		do {
			try {
				value = Double.parseDouble(sc.nextLine());
				valid = true;
			} catch (Exception e) {
				PrintUtility.printColor("Invalid input. Try again.", "red");
			}
		} while(!valid);
		
		return value;
	}
	
	public static double getPositiveDouble(Scanner sc, String type) {
		
		boolean valid = false;
		double value = 0;
		do {
			value = getValidDouble(sc);
			if(value >= 0)
				valid = true;
			else
				PrintUtility.printColor(type + " cannot be negative.", "red");

		} while(!valid);
		
		return value;
	}
	
	public static double getPositiveDoubleNonZero(Scanner sc, String type) {
		
		boolean valid = false;
		double value = 0;
		do {
			value = getValidDouble(sc);
			if(value > 0)
				valid = true;
			else if(value == 0)
				PrintUtility.printColor(type + " cannot be zero.", "red");
			else
				PrintUtility.printColor(type + " cannot be negative.", "red");

		} while(!valid);
		
		return value;
	}
	
	public static boolean yesNo(Scanner sc) {
		
		boolean valid = false;
		boolean result = false;
		do {
			String input = sc.nextLine().toLowerCase();
			if(input.equals("y") || input.equals("yes")) {
				valid = true;
				result = true;
			} else if(input.equals("n") || input.equals("no")) {
				valid = true;
				result = false;
			} else {
				PrintUtility.printColor("Invalid input. Please enter 'yes' or 'no'.", "red");
			}
		} while (!valid);
		
		return result;
	}
	
	public static String createValidPassword(Scanner sc) {
		
		String newPassword = "";
		boolean validPassword = false;
		
		do {
			String error = "Your password did not contain:\n";
			newPassword = sc.nextLine();
			// Assume password is valid, invalidate as soon as condition fails
			validPassword = true;
			
			if(newPassword.length() < 8) {
				error = error + "- The required length of 8 characters\n";
				validPassword = false;
			}
			if(!newPassword.matches(".*[abcdefghijklmnopqrstuvwxyz].*")) {
				error = error + "- A lower case character\n";
				validPassword = false;
			}
			if(!newPassword.matches(".*[ABCDEFGHIJKLMNOPQRSTUVWXYZ].*")) {
				error = error + "- A upper case character\n";
				validPassword = false;
			}
			if(!newPassword.matches(".*[\\!\\@\\#\\$\\%\\^\\&\\*\\-\\?].*")) {
				error = error + "- a special character (!@#$%^&*-?)\n";
				validPassword = false;
			}
			
			error = error + "Please try again:";
			if(!validPassword)
				PrintUtility.printColor(error, "red");
			
		} while(!validPassword);
		
		return newPassword;
	}

}