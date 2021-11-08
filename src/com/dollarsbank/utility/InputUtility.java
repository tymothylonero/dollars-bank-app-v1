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

}