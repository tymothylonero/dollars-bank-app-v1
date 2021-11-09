package com.dollarsbank.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account implements Serializable {

	private static final long serialVersionUID = -1733826301641350346L;
	
	private String accountID;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private LocalDateTime created;
	
	private double balance;
	private ArrayList<Transaction> transactions;
	
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
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<Transaction> getTransactions() {
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
		
		
//		return "accountID: " + accountID + "\nName of user: " + name + "\nAddress: " + address
//				+ ", phoneNumber=" + phoneNumber + ", created=" + created + "\nCurrent balance: " + balance + "\n";
	}
	
}