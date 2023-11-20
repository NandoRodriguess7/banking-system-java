package finSysClient;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import finSysUtil.CPFUtil;

public class Client {
	
	private String name;
	private String cpf;
	private LocalDate dateOfBirth;
	private double balance;
	private List<String> inquiry;
	
	private boolean blockedCard;
	
	public Client(String name, String cpf, LocalDate dateOfBirth) {
		this.name = name;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.balance = 0.0;
		this.inquiry = new ArrayList<>();
		this.blockedCard = false;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean isBlockedCard() {
		return blockedCard;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setBlockedCard(boolean blockedCard) {
		this.blockedCard = blockedCard;
	}
	
	// specific methods
	public boolean validateCPF() {
		return CPFUtil.validateCPF(cpf);
	}
	
	public String getCpfFormatted() {
		return CPFUtil.formatCPF(cpf);
	}
	
	public int calculateAge() {
		LocalDate today = LocalDate.now();
		Period period = Period.between(dateOfBirth, today);
		return period.getYears();
	}
	
	public void displayInformation() {
		System.out.println("Name: " + name);
		System.out.println("CPF: " + getCpfFormatted());
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("Age: " + calculateAge() + " years");
	}
	
	// Banking methods
	public void MakeADeposit(double value) {
		balance += value;
		System.out.println("Deposit U$ " + value + " made. New balance: U$ " + balance);
	}
	
	public void makeWithDrawal(double value) {
		if (value <= balance) {
			balance -= value;
			System.out.println("Withdrawal U$ " + value + " made. New balance: U$ " + balance);
		}
		else {
			System.out.println("Insufficient balance to make the withdrawal");
		}
	}
	
	public void makeTransfer(Client recipient, double value) {
		if (value <= balance) {
			balance -= value;
			recipient.balance += value;
			System.out.println("Transfer of U$ " + value + " made to " + 
			recipient.getName() + ". New balance: U$ " + balance);
		}
		else {
			System.out.println("Insufficient balance to make the transfer");
		}
	}
	
	// Statement Query Methods
	public void accountStatementInquiry() {
		if (inquiry.isEmpty()) {
			System.out.println("Empty statement.");
		}
		else {
			System.out.println("----Account Statement----");
			for (String transaction : inquiry) {
				System.out.println(transaction);
			}
			System.out.println("------------------------");
		}
	}
	
	// Account Payment Method
	public void payBill(double value) {
		if (value <= balance) {
			balance -= value;
			String transaction = "Bill payment in the amount of U$ " + value +
					". New balance: U$ " + balance;
			inquiry.add(transaction);
			System.out.println(transaction);
		}
		else {
			System.out.println("Insufficient balance to make the payment");
		}
	}
	
	// Alert configuration method
	public void configureAlertBelowBalance(double limit) {
		if (balance < limit) {
			System.out.println("Alert: Balance below the configured threshold (U$ " + limit + ").");
		}
		else {
			System.out.println("Alert configured, but the current balance is not below the threshold.");
		}
	}
	
}
