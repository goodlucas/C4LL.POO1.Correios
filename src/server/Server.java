package server;

import java.util.ArrayList;

import accounts.Account;
import accounts.DestinationList;
import accounts.Message;

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
	 * @return	The 'user name' of the server to notificate users.
	 */
	private String getNotificationName() {
		return "servidor";
	}
	
	/**
	 * Get the user adress to the server. 
	 * @param loginName	User name
	 * @return	Format: loginName@server.name
	 */
	public String getUserAddress(String loginName) {
		return loginName + "@" + getServerName();
	}
	
	/**
	 * Create an account into the server.
	 * @param a	The account to be created.
	 * @throws ServerException If an account with the same name already was
	 * 							created in the server.
	 */ 
	public void addAccount(Account a) throws ServerException {
		String	loginName = a.getUser().getLoginName();
		
        if (accounts.containsKey(loginName)) {
			throw new ServerException("Conta com mesmo login já existe.");
        }
        accounts.put(loginName, a);
        notificationWelcome(loginName);
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
	 * sent to the sender as notification failure.
	 * @param message			The message to be sent.
	 * @throws ServerException 	No destination defined.
	 */
	public void post(Message message) throws ServerException {
		DestinationList		destinations = message.getDestinations();
		ArrayList<String>	errors = new ArrayList<String>();
		
		if (destinations.isEmpty())
			throw new ServerException("A mensagem não possui destinatários.");
		/* Send message for read destination */
		for (String dest: destinations) {
			if (accounts.containsKey(dest)) {
				Account acc = accounts.get(dest);
				acc.addToInbox(message.clone());
			} else {
				errors.add(dest);
			}		
		} 
		/* Notify errors */
		for (String userFailure: errors) {
			notificationFailure(message.getFrom(), userFailure);
		}
	}
	
	/**
	 * Notify an user the failure to post a message for one or more inexistent
	 * users. If the sender does not exist in the server, the notification
	 * will not be executed, otherwise a infinte loop would happen.
	 * @param sender			Who will be notificated.
	 * @param userNameFailure	Which user does not exists.
	 */
	private void notificationFailure(String sender, String userNameFailure) {
		if (!accounts.containsKey(sender))
			return;
		String msg = "A mensagem que você tentou enviar para " +
					getUserAddress(userNameFailure) + " não pôde ser entregue"
					+ " pois o endereço não existe.";
		try {
			Message message = new Message(getNotificationName(), sender,
						"Notificação de status de entrega (falha)",	msg, false);
			post(message);
		} catch (ServerException e) {
			// Ignore exceptions.
		}
	}
	
	/**
	 * Send a wellcome message to the inbox of the new user at the moment of 
	 * the account creation. 
	 * @param a
	 * 		The new user signed
	 */
	private void notificationWelcome(String a) {
		String msg = ("Bem vindo ao PostOffice! Esperamos que desfrute das "
				+ "várias funcionalidades do sistema!");

		Message message;
		try {
			message = new Message(getNotificationName(), a, 
					"Boas Vindas", msg, false);
			post(message);
		} catch (ServerException e) {
			// Ignore exception
		}

	}
}
