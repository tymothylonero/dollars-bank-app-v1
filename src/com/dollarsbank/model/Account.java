package com.dollarsbank.model;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.dollarsbank.utility.InputUtility;

public class Account implements Serializable {

	private static final long serialVersionUID = -1733826301641350346L;
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private String accountID;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private LocalDateTime created;
	
	private double balance;
	private List<Transaction> transactions;
	
	public Account() {
		// empty constructor
	}

	public Account(String accountID, String password, String name, String address, String phoneNumber,
			LocalDateTime created, double balance) {
		this.accountID = accountID;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.created = created;
		this.balance = balance;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public String fiveTransactions() {
		
		if(transactions.size() == 0) {
			System.out.println("No transaction history!");
			return "";
		}
		
		String toReturn = "";
		for (int idx = 0; idx < transactions.size(); idx++) {
			if(idx < 5)
				toReturn = toReturn + (idx + 1) + ". " + transactions.get(idx) + "\n";
			else
				break;
		}
		return toReturn;
	}
	
	public void initialDeposit(Scanner sc, String message) {

		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println(message);
		double amount = InputUtility.getPositiveDouble(sc, "Initial deposit");
		amount = Double.parseDouble(df.format(amount));
		if(amount > 0) {
			transactions.add(0, new Transaction("Deposit", "Initial Deposit", amount, this.modifyBalance(amount), LocalDateTime.now()));
			System.out.println("Successfully deposited $" + df.format(amount));
		}
	}
	
	public void deposit(Scanner sc, String message) {

		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println(message);
		double amount = InputUtility.getPositiveDoubleNonZero(sc, "Deposit");
		amount = Double.parseDouble(df.format(amount));
		System.out.println("Enter a description for this deposit:");
		String description = sc.nextLine();
		transactions.add(0, new Transaction("Deposit", description, amount, this.modifyBalance(amount), LocalDateTime.now()));
		System.out.println("Successfully deposited $" + df.format(amount));
	}
	
	public void withdraw(Scanner sc, String message) {

		if(this.getBalance() <= 0) {
			System.out.println("Cannot withdraw from an account with no money!");
			return;
		}
		
		df.setRoundingMode(RoundingMode.DOWN);
		
		System.out.println(message);
		double amount = InputUtility.getPositiveDoubleNonZero(sc, "Withdrawal");
		amount = Double.parseDouble(df.format(amount));
		if(amount > this.getBalance()) {
			System.out.println("Cannot withdraw more than what is in your account!");
		} else {
			System.out.println("Enter a description for this withdrawal:");
			String description = sc.nextLine();
			transactions.add(0, new Transaction("Withdrawal", description, (amount * -1), this.modifyBalance(amount * -1), LocalDateTime.now()));
			System.out.println("Successfully withdrew $" + df.format(amount));
		}
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public double getBalance() {
		df.setRoundingMode(RoundingMode.DOWN);
		return Double.parseDouble(df.format(balance));
	}

	public void setBalance(double balance) {
		df.setRoundingMode(RoundingMode.DOWN);
		this.balance = Double.parseDouble(df.format(balance));
	}
	
	public double modifyBalance(double balance) {
		this.balance += balance;
		return this.balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		
		return "Account in the name of " + name
				+ "\nAccount ID: " + accountID
				+ "\nAddress: " + address
				+ "\nContact number: " + phoneNumber
				+ "\nCurrent balance: " + balance
				+ "\nCreated on: " + created;
	}
	
}