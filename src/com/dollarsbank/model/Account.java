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
	
}