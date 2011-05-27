package accounts;

/**
 * Store information about an user. This should be accessed from Accounts.
 */
public class User {
	private String	loginName;
	private	String	password;

	public User(String loginName, String password) {
		setLoginName(loginName);
		setPassword(password);
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}	
}
