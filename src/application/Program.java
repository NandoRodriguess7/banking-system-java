package application;

import java.time.LocalDate;

import finSysAccount.BankAccount;
import finSysClient.Client;
import finSysTransaction.Transaction;

public class Program {

	public static void main(String[] args) {
		
		// Creating client. Example of a banking system with customers from Brazil
		Client client1 = new Client("João da Silva", "123.456.789-09", LocalDate.of(1980, 1, 1), new BankAccount(1, 100.00, 200.00));
		Client client2 = new Client("Maria Oliveira", "987.654.321-09", LocalDate.of(1992, 5, 15), new BankAccount(2, 200.00, 400.00 ));
		
		System.out.println(client1);
		System.out.println(client2);
		
		// Creating bank account
		BankAccount bankAccount1 = new BankAccount(1, 100.00, 200.00);
		BankAccount bankAccount2 = new BankAccount(2, 200.00, 400.00);
		
		System.out.println(bankAccount1);
		System.out.println(bankAccount2);
		
		// Carrying out transactions
		Transaction.transfer(bankAccount1, bankAccount2, 300.00);
		Transaction.payment(bankAccount2, 100.00, "Conta de Luz");
		
	}

}
