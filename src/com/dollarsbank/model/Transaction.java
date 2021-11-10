package com.dollarsbank.model;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 6477040768951030656L;
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
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
		df.setRoundingMode(RoundingMode.DOWN);
		return Double.parseDouble(df.format(amount));
	}

	public void setAmount(double amount) {
		df.setRoundingMode(RoundingMode.DOWN);
		this.amount = Double.parseDouble(df.format(amount));
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
		df.setRoundingMode(RoundingMode.DOWN);
		if(amount < 0)
			return type + " for -$" + df.format(amount * -1) + "\nDescription: " + description + "\nAccount balance is $" + df.format(accountBalance) + " as of:\n" + timestamp + "\n";
		else
			return type + " for $" + df.format(amount) + "\nDescription: " + description + "\nAccount balance is $" + df.format(accountBalance) + " as of:\n" + timestamp + "\n";
	}

}