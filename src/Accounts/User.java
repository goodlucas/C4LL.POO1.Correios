package Accounts;

import Accounts.User;

public class User {
	private String login;

	public User() {
		this.login = "";
	}

	public User(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int hashCode() {
		return 42 * login.hashCode();
	}

	public boolean equals(Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return this.login.equals(u.getLogin());
		}
		return false;

	}

}
