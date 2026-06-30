package banking.app;

import bankingExceptions.InvalidAmountExceptions;
import bankingExceptions.InsufficientBalanceException;
import bankingExceptions.DailyLimitExceededException;
import bankingExceptions.InvalidAccountExceptions;

public class BankAccount {
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	static final double DAILY_LIMIT =50000;

	public BankAccount(int accountNumber, String accountHolder, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public static double getDailyLimit() {
		return DAILY_LIMIT;
	}
	
	public void deposit(double amount) throws InvalidAmountExceptions{
		if (amount<= 0)
			throw new InvalidAmountExceptions("Deposit amount" + "must be greater than zero ");
		
		balance += amount;
		System.out.println("Deposit successful");
		System.out.println(" current Balance "+ balance);
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountExceptions, DailyLimitExceededException{
		if(amount<=0)
			throw new InvalidAmountExceptions("withdraw amount must be greater than Zero");
		if(amount > DAILY_LIMIT)
			throw new DailyLimitExceededException("Daily limit Exceeded");
		
		balance += amount;
		System.out.println("Withdraw of Rs "+ amount + "successful");
		System.out.println("current balance is "+ balance);
		
	}
	public void transfer(BankAccount reciever, double amount) throws InvalidAmountExceptions, InsufficientBalanceException, DailyLimitExceededException{
		
		withdraw(amount);
		reciever.balance += amount;
		System.out.println("Transfer Successful");
	}
	public void display() {
		System.out.println("----------------------------------------------");
		System.out.println("Account No "+ accountNumber+ "\n Account Holder "+ accountHolder + "\n Balance "+balance);
	}

}
