package accounts;


public class User {
	private String	loginName;
	private	boolean	isLogged;

	public User(String login) {
		setLoginName(login);
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String login) {
		this.loginName = login;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public boolean isLogged() {
		return isLogged;
	}

//	public int hashCode() {
//		final int	HASH_SALT = 42;
//		
//		return HASH_SALT * loginName.hashCode();
//	}
//
//	public boolean equals(Object o) {
//		if (o instanceof User) {
//			User u = (User) o;
//			return this.loginName.equals(u.getLogin());
//		}
//		return false;
//	}

}
