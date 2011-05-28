package server;

import java.util.ArrayList;

import accounts.Account;

/**
 * Server to accounts and message traffic.
 */
public class Server {
	private AccountMap	accounts;
	private String		serverName;

	/**
	 * Server constructor receives the server name, and it will not be able
	 * to be changed afterwards.
	 * @param serverName	The server name.
	 */
	public Server(String serverName) {
		setServerName(serverName);
		accounts = new AccountMap();
	}

	/**
	 * Set server name. This method should be private to avoid the name to be
	 * changed.
	 * @param serverName	The server name.
	 */
	private void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * @return	The server name.
	 */
	public String getServerName() {
		return serverName;
	}
	
	/**
	 * Create an account into the server.
	 * @param a	The account to be created.
	 * @throws ServerException If an account with the same name already was
	 * 							created in the server.
	 */
	public void createAccount(Account a) throws ServerException {
		String	loginName = a.getUser().getLoginName();
		
        if (accounts.containsKey(loginName)) {
			throw new ServerException("Conta com mesmo login já existe.");
        }
        accounts.put(loginName, a);
	}
	
	/**
	 * Get an registered account in server.
	 * @param loginName	User login name
	 * @param password	User password
	 * @return	the Account in the server. Null if no login matches.
	 * @throws ServerException	When login and password does not match.
	 */
	public Account getAccount(String loginName, String password) 
			throws ServerException {
		Account	toRet = accounts.get(loginName);
		
		if (toRet == null)
			return null;
		if (toRet.getUser().getPassword().equals(password)) {
			return toRet;
		} else {
			throw new ServerException("Usuário e senha incorretos.");
		}
	}

	/**
	 * Post a message into the destination accounts. If one or more destination
	 * does not exists, they are ignored and a error is throwed at the end.
	 * If the message does not have at least one destination, an error is
	 * throwed.
	 * @param message			The message to be sent.
	 * @throws ServerException	When at least one destination was not found,
	 * 							and when the message has no destinations.
	 */
	public void post(Message message) throws ServerException {
		ArrayList<String>	destinations = message.getDestinations();
		ArrayList<String>	errors = new ArrayList<String>();
		
		if (destinations.isEmpty())
			throw new ServerException("A mensagem não possui destinatários.");
		for (String dest: destinations) {
			if (accounts.containsKey(dest)) {
				Account acc = accounts.get(dest);
				acc.addToInbox(message);
			} else {
				errors.add("Conta " + dest + " não encontrada.");
				// TODO : Not found account should be delivered by message.
			}		
		}
		if (!errors.isEmpty())
			throw new ServerException(errors.toString());
	}
}
