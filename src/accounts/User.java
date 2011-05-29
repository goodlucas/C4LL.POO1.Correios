package accounts;

/**
 * Store information about an user. This should be accessed from Accounts.
 */
public class User {
	private String	loginName;
	private	String	password;

	/**
	 * @param loginName	User login name. Can not be an empty string.
	 * @param password	User password. Can be an empty string.
	 */
	public User(String loginName, String password) {
		setLoginName(loginName);
		setPassword(password);
	}

	/**
	 * @return	User login name.
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Set the user login name.
	 * @param loginName	user login name.
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * Set the user password.
	 * @param password	The new password. Can be an empty string, for no 
	 * 					password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return	The user password.
	 */
	public String getPassword() {
		return password;
	}	
}
	