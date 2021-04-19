package com.css.bankapplication.dto;

import java.util.List;

import com.css.bankapplication.dao.IBankServiceProvider;
import com.css.bankapplication.exceptions.InsufficientFundException;
import com.css.bankapplication.exceptions.InvalidAccountNoException;

public class Bank implements IBankServiceProvider {

	private String IFSC;
	private String name;
	private String branch;
	//private BankAccount[] accounts;
	private List<BankAccount> accounts;

	public Bank(String iFSC, String name, String branch, List<BankAccount> accounts) {
		super();
		IFSC = iFSC;
		this.name = name;
		this.branch = branch;
		this.accounts = accounts;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	

	@Override
	public String toString() {
		return "Bank [IFSC=" + IFSC + ", name=" + name + ", branch=" + branch + ", accounts=" + accounts + "]";
	}

	@Override
	public BankAccount checkAccount(String accountNo) throws InvalidAccountNoException {
		BankAccount foundAccount = null;
		for (BankAccount account : accounts) {
			if (account.getAccountNo().equals(accountNo)) {
				foundAccount = account;
				break;
			}
		}
		if (foundAccount == null) {
			throw new InvalidAccountNoException("The account number is invalid...!");
		}
		return foundAccount;
	}

	@Override
	public double getBalance(String accountNo) throws InvalidAccountNoException {
		double balance = 0.0;
		BankAccount foundAccount = this.checkAccount(accountNo);
		if (foundAccount != null) {
			balance = foundAccount.getBalance();
		}
		return balance;
	}

	@Override
	public boolean depositMoney(String accountNo, double amount) throws InvalidAccountNoException {
		boolean depositFlag = false;
		BankAccount foundAccount = this.checkAccount(accountNo);
		if (foundAccount != null) {
			double newBalance = foundAccount.getBalance() + amount;
			foundAccount.setBalance(newBalance);
			depositFlag = true;
		}
		return depositFlag;
	}

	@Override
	public boolean withdrawMoney(String accountNo, double amount)
			throws InvalidAccountNoException, InsufficientFundException {
		boolean withdrawFlag = false;
		BankAccount foundAccount = this.checkAccount(accountNo);
		if (foundAccount != null) {
			double balance = foundAccount.getBalance();
			if (balance >= amount) {
				foundAccount.setBalance(balance - amount);
				withdrawFlag = true;
			} else {
				throw new InsufficientFundException();
			}
		}
		return withdrawFlag;
	}

	@Override
	public boolean transferMoney(String fromAccountNo, String toAccountNo, double amount)
			throws InvalidAccountNoException, InsufficientFundException {
		boolean transferFlag = false;
		boolean withdrawStatus = withdrawMoney(fromAccountNo, amount);
		boolean depositStatus = depositMoney(toAccountNo, amount);

		if (withdrawStatus && depositStatus)
			transferFlag = true;
		return transferFlag;
	}

}
