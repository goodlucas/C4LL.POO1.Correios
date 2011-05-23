package Accounts;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
	private List<User> accounts;

	/**
	 * Constructor of the Accounts class
	 */
	public Accounts() {
		accounts = new ArrayList<User>();
	}

	/**
	 * addUser method, use to add an user to the ArrayList of accounts, this
	 * checks if the user already exists.
	 */
	public void addUser(User user) {
		if (userExists(user))
			System.out.println("Sorry, but the user already exists!");
		else {
			this.accounts.add(user);
			System.out.println("Account sucessfully created!");
		}
	}

	public Boolean userExists(User user) {
		if (this.accounts.contains(user))
			return true;
		else
			return false;
	}

}
