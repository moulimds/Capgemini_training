package banking.app;

import java.util.*;

import bankingExceptions.InvalidAmountExceptions;
import bankingExceptions.InsufficientBalanceException;
import bankingExceptions.DailyLimitExceededException;
import bankingExceptions.InvalidAccountExceptions;


public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		bank.addAccount(new BankAccount(101, "mouli", 500000));
		bank.addAccount(new BankAccount(102, "mahes", 500000));
		
		try {
			System.out.println("Enter Sender account number");
			int sender= sc.nextInt();
			System.out.println(" Enter reciever account Number");
			int reciever = sc.nextInt();
			System.out.println("Enter transfer amount");
			double amount = sc.nextDouble();
			
			BankAccount senderObj = bank.searchAccount(sender);
			BankAccount recieveObj = bank.searchAccount(reciever);
			
			senderObj.transfer(recieveObj, amount);
			senderObj.display();
			recieveObj.display();
			
		}
		catch(InvalidAmountExceptions am) {
			System.err.println(am.getMessage());
		}
		catch(InsufficientBalanceException in) {
			System.err.println(in.getMessage());
		}
		catch(InvalidAccountExceptions ina) {
			System.err.println(ina.getMessage());
		}
		catch(DailyLimitExceededException d) {
			System.err.println(d.getMessage());
		}
		
		sc.close();

	}

}
