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
			System.out.println("Please enter your selection:");
			
			try {
				input = Integer.parseInt(sc.nextLine());
				if(input > 0 && input <= options.length)
					valid = true;
				else
					System.out.println(input + " is not a valid selection.");
				
			// Input that is not an integer
			} catch (NumberFormatException e) {
				System.out.println("That is not an integer!");
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
				System.out.println("Invalid input. Try again.");
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
				System.out.println(type + " cannot be negative.");

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
				System.out.println(type + " cannot be zero.");
			else
				System.out.println(type + " cannot be negative.");

		} while(!valid);
		
		return value;
	}

}