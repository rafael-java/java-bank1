package bank;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * This class is responsible for declaring the account for the AccountUtility class
 */
public class Account {

	// it has the following attributes:
	private String number;
    private static int counter = 0;
    public final int objectId;
	private Double balance;
	private User user;
	
	// when it is created, the account will create automatically an id 
	public Account() {
        this.objectId = counter++;
        this.counter += 1;
	}

	public Account(String number, Double balance, User user) {
		this();
		this.number = number;
		this.balance = balance;
		this.user = user;
	}

	//Getters and Setters
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getObjectId() {
		return objectId;
	}

	// operations for debit and deposit
//	public void deposit (Float value) {
//		this.balance = this.balance + value;
//	}
//
//	public void debit (Float value) {
//		this.balance = this.balance - value;
//	}

}
