package com.css.bankapplication.main;

import java.util.ArrayList;
import java.util.List;

import com.css.bankapplication.dto.Bank;
import com.css.bankapplication.dto.BankAccount;
import com.css.bankapplication.exceptions.InsufficientFundException;
import com.css.bankapplication.exceptions.InvalidAccountNoException;

public class Main {

	public static void main(String[] args) {
		
		/*BankAccount[] accounts=new BankAccount[3];
		accounts[0]=new BankAccount("Raj");
		accounts[1]=new BankAccount("Jaikumar");
		accounts[2]=new BankAccount("kumar");
		*/
		
		List<BankAccount> accounts=new ArrayList<BankAccount>();
		accounts.add(new BankAccount("Raj"));
		accounts.add(new BankAccount("Jaikumar"));
		accounts.add(new BankAccount("kumar"));
		
		Bank axis=new Bank("AXIS123","Axis Bank","Chennai",accounts);
		//System.out.println(accounts.get(0).toString());
		
		try {
			System.out.println("the account is:"+axis.checkAccount("1003"));
		} catch (InvalidAccountNoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println("Deposit: "+axis.depositMoney("17654", 560.87));
		} catch (InvalidAccountNoException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("Balance: "+axis.getBalance("1002"));
		} catch (InvalidAccountNoException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("Withdraw: "+axis.withdrawMoney("1002", 340));
		} catch (InvalidAccountNoException | InsufficientFundException e) {
			System.out.println(e.getMessage());
			
		}
		try {
			System.out.println("Balance: "+axis.getBalance("1002"));
		} catch (InvalidAccountNoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("Transfer: "+axis.transferMoney("1002", "1001",1000));
		} catch (InvalidAccountNoException | InsufficientFundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("From Account Balance: "+axis.getBalance("1002"));
		} catch (InvalidAccountNoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("To Account Balance: "+axis.getBalance("1001"));
		} catch (InvalidAccountNoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
