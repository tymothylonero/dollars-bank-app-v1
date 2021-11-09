package com.dollarsbank.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 6477040768951030656L;
	
	private String type;
	private String description;
	private double amount;
	private double accountBalance;
	private LocalDateTime timestamp;
	
	public Transaction(String type, String description, double amount, double accountBalance, LocalDateTime timestamp) {
		super();
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.accountBalance = accountBalance;
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		if(amount < 0)
			return type + " for -$" + (amount * -1) + "\nDescription: " + description + "\nAccount balance is $" + accountBalance + " as of:\n" + timestamp + "\n";
		else
			return type + " for $" + amount + "\nDescription: " + description + "\nAccount balance is $" + accountBalance + " as of:\n" + timestamp + "\n";
	}

}