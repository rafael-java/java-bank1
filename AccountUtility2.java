package bank;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

/*
 * This class is responsible for all the operations involved in the main class
 */

public class AccountUtility2 {

	// some declarations
	private Account[] accounts = new Account[10];
//	private Users users = new Users();
	Scanner scan = new Scanner(System.in);

	// operation to add an account, it gets an id from the user (which is not very well done, but it is what it is), and then adds an account to that array's position
	public void addAccount(Integer id, String number, Double balance, User user) {
		accounts[id] = new Account(number, balance, user);
	}

	/*operation to edit an account, it gets the information from the user, then
	 * it loops through all the accounts to find a position which contains an account with 
	 * the same number as the one typed, then it gets the id created with the account, and that 
	 * represents the index, which is used to set a new number, balance and user.
	 * this will only work if the id numbers are sorted correctly
	*/
	
	public void editAccount(Integer id, String number, Double balance, User user) {

		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				
				accounts[id].setNumber(number);
				accounts[id].setBalance(balance);
				accounts[id].setUser(user);
			}
		}
	}

	// operation responsible for printing the accounts
	public void printAccounts() {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				System.out.println("account id: "+i+" account owner: " + accounts[i].getUser().getName() + " account number: "
						+ accounts[i].getNumber());
			}
		}
	}

	// extra operation, responsible for printing the accounts with balance, because this is a private information
	public void printAccounts_withBalance() {
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("account owner: " + accounts[i].getUser().getName() + " account number: "
					+ accounts[i].getNumber() + " account balance: " + accounts[i].getBalance());
		}
	}

	// extra operation, responsible for printing the balance for one single account
	public void printBalance(String number) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && number.equals(accounts[i].getNumber())) {
				System.out.println("account owner: " + accounts[i].getUser().getName() + " account balance: "
						+ accounts[i].getBalance());
			}
		}
	}

	// adds balances for all the accounts owned by the same user
	public void addBalances(String name) {
		Double sum = 0.0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && name.equals(accounts[i].getUser().getName())) {
				sum += accounts[i].getBalance();
			}
		}
		System.out.println("total balance for " + name + " : " + sum);
	}

	// operation to deposit. Using a simple for, it searches for the 
	// account with a certain number, which is a string, that's why it uses the equals() function
	// then it sets the new balance to the old balance plus the value
	public void deposit(String number, Double value) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && number.equals(accounts[i].getNumber())) {
				accounts[i].setBalance(accounts[i].getBalance() + value);
			}
		}
	}

	// operation to withdraw. Using a simple for, it searches for the account with a certain number
	// then it checks if the value is greater than 0, because if it is, then there's no way to withdraw any more
	// if it isn't, then it sets the new balance to the older balance minus the value
	public void withdraw(String number, Double value) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && number.equals(accounts[i].getNumber())) {
				while ((accounts[i].getBalance() - value) < 0) {
					System.out.println("Invalid value. \n Type an amount to withdraw");
					value = scan.nextDouble();
				}
				accounts[i].setBalance(accounts[i].getBalance() - value);
			}
		}
	}
}
