package com.dollarsbank.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.dollarsbank.model.Account;

public class FileUtility {
	
	private static final String FILE_PATH = "resources/accounts.data"; 
	
	public static ArrayList<Account> load() {
		
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				PrintUtility.printColor("Error: Could not create file!", "red");
			}
			PrintUtility.printColor("Info: Created new file: " + FILE_PATH, "yellow");
			return new ArrayList<Account>();
		}
		
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
//			if(!file.exists()) {
//				file.createNewFile();
//				PrintUtility.printColor("Info: Created new file: " + FILE_PATH, "yellow");
//				return new ArrayList<Account>();
//			} else {
				@SuppressWarnings("unchecked")
				ArrayList<Account> accounts = (ArrayList<Account>) reader.readObject();
				return accounts;
//			}
			
		} catch(IOException e) {
			PrintUtility.printColor("Info: Created new file: " + FILE_PATH, "yellow");
			return new ArrayList<Account>();
		} catch(ClassNotFoundException e) {
			PrintUtility.printColor("Error: Could not load file!", "red");
		}
		
		return new ArrayList<Account>();
	}
	
	public static boolean save(ArrayList<Account> accounts) {
		
		File file = new File(FILE_PATH);
		
		try {
			if(!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			PrintUtility.printColor("IOException: Could not create file '" + FILE_PATH + "'", "red");
		}
		
		try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			
			writer.writeObject(accounts);
			
		} catch (IOException e) {
			PrintUtility.printColor("Error: Could not save file!!!", "red");
		}
		
		return true;
	}

}