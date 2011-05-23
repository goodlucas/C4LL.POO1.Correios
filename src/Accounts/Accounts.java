package Accounts;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
	private List<User> accounts;

	public Accounts() {
		accounts = new ArrayList<User>();
	}

	public void addUser(User user) {
		if (this.accounts.contains(user))
			System.out.println("Sorry, but the user already exists!");
		else{
			this.accounts.add(user);
			System.out.println("Account sucessfully created!");
		}
	}

}
