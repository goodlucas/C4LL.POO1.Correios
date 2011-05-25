package accounts;


public class User {
	private String	loginName;

	public User(String login) {
		setLoginName(login);
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String login) {
		this.loginName = login;
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
