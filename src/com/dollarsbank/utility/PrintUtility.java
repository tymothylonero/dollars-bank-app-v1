package com.dollarsbank.utility;

public class PrintUtility {

	public static void boxedPrint(String message) {
		String line = "-".repeat(message.length());
		System.out.println("+-" + line + "-+");
		System.out.println("| " + message + " |");
		System.out.println("+-" + line + "-+");
	}
	
}