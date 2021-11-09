package com.dollarsbank.utility;

import java.util.List;

import com.dollarsbank.model.Account;

public class AccountUtility {
	
	public static Account findAccountWithCredentials(List<Account> accounts, String accountID, String password) {
		
		for(Account a : accounts) {
			if( accountID.equals(a.getAccountID()) && password.equals(a.getPassword()))
				return a;
		}
		
		return null;
	}

}