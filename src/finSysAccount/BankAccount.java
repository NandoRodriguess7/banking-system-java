package finSysAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	
	private static List<BankAccount> liveAccounts = new ArrayList<>();
	
	private int accountNumber;
	private double balance;
	private double withDrawalLimit;
	private List<String> transactionHistory;
	
	public BankAccount(int accountNumber, double balance, double withDrawalLimit) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.withDrawalLimit = withDrawalLimit;
		this.transactionHistory = new ArrayList<>();
		recordTransaction("Account Opening", 0);
		liveAccounts.add(this);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithDrawalLimit() {
		return withDrawalLimit;
	}

	public void setWithDrawalLimit(double withDrawalLimit) {
		this.withDrawalLimit = withDrawalLimit;
	}

	public List<String> getTransactionHistory() {
		return new ArrayList<>(transactionHistory);
	}
	
	public void deposit(double value) {
		if (value > 0) {
			balance += value;
			recordTransaction("Deposit", value);
		}
		else {
			System.out.println("Invalid deposit amount.");
		}
	}
	
	public boolean withDraw(double value) {
		if (value > 0 && value <= balance && value <= withDrawalLimit) {
			balance -= value;
			recordTransaction("Withdraw", value);
		}
		else {
			System.out.println("Invalid withdrawal. Check the withdrawal amount or limit.");
		}
		return false;
	}
	
	public void transfer(BankAccount destiny, double value) {
		if (value > 0 && value <= balance && value <= withDrawalLimit) {
			balance -= value;
			destiny.deposit(value);
			recordTransaction("Transfer to account " + destiny.getAccountNumber(), value);
		}
		else {
			System.out.println("Invalid transfer. Check the amount, balance, or withdrawal limit.");
		}
	}
	
	public void calculateApplyInterest(double tax) {
		double interest = balance * tax / 100;
		balance += interest;
		recordTransaction("Application of interest", interest);
	}
	
	private void recordTransaction(String type, double value) {
		transactionHistory.add(String.format("%s: %.2f",type, value));
	}
	
	public static List<BankAccount> getLiveAccounts(){
		return new ArrayList<>(liveAccounts);
	}
	
}
