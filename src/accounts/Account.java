package accounts;

import server.Server;
import server.ServerException;

/**
 * Account class. Store messages of the account.
 */
public class Account {
	private	Messages	inbox = new Messages();
	private	Messages	trash = new Messages();
	private Server		server;
	private	User		loggedUser;
	private	int			nextId = 1;
	
	/**
	 * @param server	Server which the account should be registered.
	 * @param user		User information of the account.
	 * @throws ServerException	
	 * @throws AccountException
	 */
	public Account(Server server, User user) throws ServerException, 
				AccountException {
		setUser(user);
		setServer(server);
	}
	/**
	 * @return	The login name of associated user to the account.
	 */
	public String getLoginName() {
		return this.getUser().getLoginName();
	}
	
	/**
	 * Set server to the account be registered.
	 * Note: this method should be called just once, because it will register
	 * the account into the server.
	 * @param server	Server instance to the account be registered.
	 * @throws AccountException	The server is null.
	 * @throws ServerException 
	 */
	private void setServer(Server server) throws AccountException, 
			ServerException {
		if (server == null)
			throw new AccountException("Não há servidor para a nova conta.");
		this.server = server;
		server.createAccount(this);
	}
	
	/**
	 * @return The instance to the user information.
	 */
	public User getUser() {
		return loggedUser;
	}

	/**
	 * Set user is a private method to set which user own the account.
	 * Should not be changed after one call.
	 * @param user	User information.
	 * @throws AccountException The user is null.
	 */
	private void setUser(User user) throws AccountException {
		if (user == null)
			throw new AccountException("Nenhum usuário está definido " + 
					"para a conta.");
		this.loggedUser = user;
	}
	
	/**
	 * Send a message to the server.
	 * @param message	Message instance.
	 * @throws ServerException Some server problem. See Server.post()
	 */
	public void send(Message message) throws ServerException {
		 server.post(message);		
	}

	/**
	 * Add a message to the inbox. This method is called from the server.
	 */
	public void addToInbox(Message message) {
		message.setMessageId(nextId++);
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
	// TODO: Create accessors for trash and inbox. Like getcount
	
	/**
	 * Clear messages in trash.
	 */
	public void clearTrash() {
		// TODO: Should this function return some value?
		trash.clear();
	}
	
	/**
	 * Test if a contains b.
	 * @param a Complete string
	 * @param b Partial string
	 * @return true when b is inside a.
	 */
	private boolean matchFilter(String a, String b) {
		return a.toLowerCase().contains(b.toLowerCase());
	}
	
	/**
	 * Get messages from the list filtering by read, unread and the filter 
	 * string.
	 * @param list	Which message list filter. Pass either inbox or trash.
	 * @param read		If should return read messages.
	 * @param unread	If should return unread messages.
	 * @param filter	Filter string. Null to no filter.
	 * @return	The filtered message list. Empty list if no results.
	 */
	private Messages getMessages(Messages list, boolean read, boolean unread,
			String filter) {
		/* Optimization: if no filter, just return the list */
		if ((list == null || list.isEmpty()) && read && unread)
			return list;
		
		Messages	filteredMessages = new Messages();		
		for (Message msg: list) {
			boolean	canAdd;
			
			canAdd = (msg.getIsRead() && read) || (!msg.getIsRead() && unread);
			if (canAdd && (filter != null && !filter.isEmpty())) {
				canAdd = matchFilter(msg.getFrom(), filter);
			}
			if (canAdd)
				filteredMessages.add(msg);
		}
		return filteredMessages;
	}
	
	/**
	 * Get messages from the inbox with filtering options.
	 * @param filter	Filter string. Null or empty for skip.
	 * @param read		Should return read messages.
	 * @param unread	Should return unread messages.
	 * @return	Message list of filter result.
	 */
	public Messages getInbox(String filter, boolean read, boolean unread) {
		return getMessages(this.inbox, read, unread, filter);
	}

	/**
	 * Get messages from the trash with filtering options.
	 * @param filter	Filter string. Null or empty for skip.
	 * @param read		Should return read messages.
	 * @param unread	Should return unread messages.
	 * @return	Message list of filter result.
	 */	
	public Messages getTrash(String filter, boolean read, boolean unread) {
		return getMessages(this.inbox, read, unread, filter);
	}
	
	/**
	 * An account should be equal when the other object is equal, if not,
	 * when the login name is the same.
	 */
	public boolean equals(Object o) {
		Account	objAccount;
		
		if (this == o)
			return true;
	    if (o instanceof Account) {
		    objAccount = (Account) o;
		    return getLoginName().equals(objAccount.getLoginName());
	    }
	    return false;
	}
	
	/**
	 * Get the Hash Code of the account based on the login name information.
	 * @return	The hash times 42.
	 */
	public int hashCode() {
		/* 42 = Answer to the Ultimate Question of Life, 
		 * 		the Universe, and Everything */
		final int	HASH_SALT = 42;
		int 		hashResult = HASH_SALT * getLoginName().hashCode();
		
		return hashResult;
	}
}
