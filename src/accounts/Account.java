package accounts;

import server.Message;
import server.Server;
import server.ServerException;

public class Account {
	private	User		loggedUser;
	private	Messages	inbox;
	private	Messages	trash;
	private Server		server;
	
	public Account(Server server, User user) throws ServerException {
		inbox = new Messages();
		trash = new Messages();
		this.server = server;
		setUser(user);
		server.createAccount(this);
	}
	
	public void send(Message message) throws ServerException {
		 server.post(message);		
	}
	
	public User getUser() {
		return loggedUser;
	}

	public void setUser(User user) {
		this.loggedUser = user;
	}
	
	/**
	 * Add a message to the inbox. This method is called from the server.
	 */
	public void addToInbox(Message message) {
		inbox.add(message);
	}

	/**
	 * Move a message from the inbox to the trash.
	 * @param message What message should me moved.
	 * @throws AccountException When message is not on inbox.
	 */
	public void moveToTrash(Message message) throws AccountException {
		if (!inbox.remove(message))
			throw new AccountException("Mensagem não encontrada na entrada.");
		trash.add(message);
	}
	
	// TODO: Add 'getInbox(read/unread,[filter])', 'getTrash(..)'
	// TODO: Add 'clearTrash()'

//	/**
//	 * An account should be equal when the other object is equal, if not,
//	 * when the login name is the same.
//	 */
//	public boolean equals(Object o) {
//		Account	objAccount;
//		
//		if (this == o)
//			return true;
//	    if (!(o instanceof Account))
//	    	return false;
//	    objAccount = (Account) o;
//	    return (this.getLoginName().equals(objAccount.getLoginName()));
//	}
//	
//	/**
//	 * Get the Hash Code of the account based on the login name information.
//	 */
//	public int hashCode() {
//		final int	SALT = 42;
//		int 		hashResult = 1;
//		
//		hashResult *= SALT;
//		hashResult += loginName.hashCode();
//		return hashResult;
//	}
}
