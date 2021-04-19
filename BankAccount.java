package com.css.bankapplication.dto;

public class BankAccount {

	private String accountNo;
	private String name;
	private double balance;
	static private int lastAssignedNo;

	static {
		lastAssignedNo = 1000;
	}

	public BankAccount(String accountNo, String name, double balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public BankAccount() {
	}

	// single line comment
	/*
	 * multi line comment
	 */
	public BankAccount(String name) {
		super();
		lastAssignedNo ++;
		this.accountNo = "" + lastAssignedNo;// Integer.toString(lastAssignedNo+1);
		
		this.name = name;
		this.balance = 1000.00;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}

}
