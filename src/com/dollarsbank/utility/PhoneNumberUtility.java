package com.dollarsbank.utility;

public class PhoneNumberUtility {

	public static String formatPhoneNumber(String phoneNumber) {
		
		if(phoneNumber.length() >= 10)
			return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
		else if(phoneNumber.length() >= 5)
			return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3);
		return phoneNumber;
	}
	
}
