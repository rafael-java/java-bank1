package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * This class is the main class for the Account class with the use of arrays, 
 * since it uses arrays, it limits the number of accounts that can be created
 */

public class MainBank1 {

	public static void main(String[] args) {
		// first declarations
		AccountUtility2 util1 = new AccountUtility2();
		Scanner scan = new Scanner(System.in);
		Users users = new Users();

		// main menu (start)
		System.out.println("Type 1 to add an account, 2 to edit, 3 to continue");
		Integer number = scan.nextInt();

		// while declaration so it stays in the loop while checking the numbers typed
		while (true) {
			// if number = 1, then adds an account
			while (number == 1) {
				System.out.println("Type the account id (must start at 0, maximum 9)");
				Integer accID = scan.nextInt();
				// checks if account id is greater than 9, if so, it is invalid because of the
				// array limit
				while (accID > 9) {
					System.out.println("Account id is invalid (must start at 0 and end at 9)");
					accID = scan.nextInt();
				}

				// asks for the number of account. The number is a string because it can contain
				// letters.
				System.out.println("Type a number for the account");
				// because of Java, it gets the next line then captures the string typed

				scan.nextLine();
				String accNumber = scan.nextLine();

				// asks for the amount for the balance
				System.out.println("Type an amount for the balance");
				Double accBalance = scan.nextDouble();

				// asks for the name of the account's owner
				System.out.println("Type a name for the owner");
				scan.nextLine();
				String accOwner = scan.nextLine();

				// adds the account
				util1.addAccount(accID, accNumber, accBalance, users.addUser(accOwner));
				System.out.println("ok");

				// asks for an input to continue operations
				System.out.println("Type 1 to add an account, 2 to edit, 3 to continue");
				number = scan.nextInt();
			}

			// if number is 2, then edits an account, the user is responsible for knowing the number of the account and checking if that number is right
			while (number == 2) {

				// prints accounts so the user can know what the status is
				util1.printAccounts();
				
				// same as before, it asks for the number, amount and owner's name
				System.out.println("Type the account id");
				Integer accID = scan.nextInt();
				
				System.out.println("Type a number for the account");
				scan.nextLine();
				String accNumber = scan.nextLine();

				System.out.println("Type an amount for the balance");
				Double accBalance = scan.nextDouble();

				System.out.println("Type a name for the owner");
				scan.nextLine();
				String accOwner = scan.nextLine();
				
				// then it edits the account
				util1.editAccount(accID, accNumber, accBalance, users.addUser(accOwner));
				System.out.println("ok");

				// asks for input
				System.out.println("Type 1 to add an account, 2 to edit, 3 to continue");
				number = scan.nextInt();
			}
			// if number is 3, it goes out of the loop
			if (number == 3) {
				break;
			} else if (number > 3){

				// else if another number is typed, this message will appear
				System.out.println("Invalid number");
				System.out.println("Type 1 to add an account, 2 to edit, 3 to continue");
				number = scan.nextInt();
			}
		}

		// at the end it shows all the accounts' information
		util1.printAccounts();

		//main menu (continuation)
		System.out.println("Type 1 to deposit, 2 to withdrawal, 3 to add balances, 4 to exit");
		Integer new_number = scan.nextInt();
		
		//another while(true) to stay in the loop
		while (true) {
			//if the inputed number is 1, it deposits 
			while (new_number == 1) {

				//asks for the number and amount to deposit
				System.out.println("Type a number for the account");
				scan.nextLine();
				String accNumber = scan.nextLine();
				util1.printBalance(accNumber);

				System.out.println("Type an amount to deposit");
				Double value = scan.nextDouble();

				//deposits into the account
				util1.deposit(accNumber, value);
				System.out.println("ok");
				//shows account balance
				util1.printBalance(accNumber);

				System.out.println("Type 1 to deposit, 2 to withdrawal, 3 to add balances, 4 to exit");
				new_number = scan.nextInt();
			}
			
			// if the inputed number is 2, then it withdraws
			while (new_number == 2) {
				// asks for an account number and prints its balance
				System.out.println("Type a number for the account");
				scan.nextLine();
				String accNumber = scan.nextLine();
				util1.printBalance(accNumber);

				System.out.println("Type an amount to withdraw");
				Double value = scan.nextDouble();
				
				//withdraws and then presents the updated balance
				util1.withdraw(accNumber, value);
				System.out.println("ok");
				util1.printBalance(accNumber);

				System.out.println("Type 1 to deposit, 2 to withdraw, 3 to add balances, 4 to exit");
				new_number = scan.nextInt();
			}
			
			// if inputed number is 3, then adds balances from the same account owner
			while (new_number == 3) {
				System.out.println("Type a name for the account");
				scan.nextLine();
				String accOwner = scan.nextLine();
				util1.addBalances(accOwner);
				
				System.out.println("Type 1 to deposit, 2 to withdraw, 3 to add balances, 4 to exit");
				new_number = scan.nextInt();
			}
			
			// if inputed number is 4, then if breaks out of the loop
			if (new_number == 4) {
				break;
				
				// for other values, the following message is presented:
			} else if (new_number > 4){
				System.out.println("Invalid number");
				System.out.println("Type 1 to deposit, 2 to withdraw, 3 to add balances, 4 to exit");
				new_number = scan.nextInt();
			}
		}
	}
}
