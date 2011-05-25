package accounts;

import java.util.ArrayList;
import java.util.List;

import server.Message;
import server.Server;

public class Accounts {
	private List<User> accounts;

	/**
	 * Constructor of the Accounts class
	 */
	public Accounts() {
		accounts = new ArrayList<User>();
	}

	/**
	 * addUser method, use to add an user to the ArrayList of accounts, this also
	 * checks if the user already exists.
	 */
	public void addUser(User user) {
		if (userExists(user))
			System.out.println("Sorry, but this user already exists dude!");
		else {
			this.accounts.add(user);
			System.out.println("Account sucessfully created!");
		}
	}

	public Boolean userExists(User user) {
		if (accounts.contains(user))
			return true;
		else
			return false;
	}
	
	public void send(Message message) {
		 Server.post(message);
		
	}

}
