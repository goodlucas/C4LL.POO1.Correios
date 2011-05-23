package main;

import Accounts.Accounts;
import Accounts.User;
import Command.Command;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Command("inbox --read uh --lol");
		//new Command("inbox --read test");
		
		//Just for testing
		Accounts acc = new Accounts();
		User a = new User("batman");
		User b = new User("Robim");
		acc.addUser(a);
		acc.addUser(b);
		
		

	}

}
