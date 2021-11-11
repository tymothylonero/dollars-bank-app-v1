package com.dollarsbank.utility;

import com.dollarsbank.application.DollarsBankApplication;

public class PrintUtility {
	
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_LIME = "\u001b[32;1m";

	public static void boxedPrint(String message) {
		if(DollarsBankApplication.isUsingColor()) {
			String line = "-".repeat(message.length());
			System.out.println(ANSI_BLUE + "+-" + line + "-+" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "| " + message + " |" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "+-" + line + "-+" + ANSI_RESET);
		} else {
			String line = "-".repeat(message.length());
			System.out.println("+-" + line + "-+");
			System.out.println("| " + message + " |");
			System.out.println("+-" + line + "-+");
		}
	}
	
	// Will only print in color if user confirms
	public static void printColor(String string, String color) {
		color = color.toLowerCase();
		if(DollarsBankApplication.isUsingColor()) {
			switch(color) {
			case "red":
				System.out.println(ANSI_RED + string + ANSI_RESET);
				break;
			case "yellow":
				System.out.println(ANSI_YELLOW + string + ANSI_RESET);
				break;
			case "blue":
				System.out.println(ANSI_BLUE + string + ANSI_RESET);
				break;
			case "green":
				System.out.println(ANSI_GREEN + string + ANSI_RESET);
				break;
			case "lime":
				System.out.println(ANSI_LIME + string + ANSI_RESET);
				break;
			default:
				System.out.println(string);
			}
		} else {
			System.out.println(string);
		}
	}
	
}