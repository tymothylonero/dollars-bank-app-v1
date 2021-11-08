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

}