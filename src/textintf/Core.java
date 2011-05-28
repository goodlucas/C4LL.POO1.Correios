package textintf;

import server.Server;
import textintf.command.Reader;
import accounts.Account;

/**
 * Store the data of the program. You should be able to access all necessary
 * data of the program from the core.
 */
public final class Core {
	private Reader	commandReader = new Reader();
	private Server	server;
	private Account	account = null;
	private boolean	resumeProgram = true;

	Core(Server server) {
		this.server = server;
	}
	
	public String getProgramName() {
		return "PostOffice";
	}
	
	/**
	 * @return	Currentely logged user. Null when the user is not logged.
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Set logged account.
	 * @param account	Instance to the account. Set null to mean that there
	 * 					is no logged user in the server.
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Commands may need read lines from the user. This Reader should be used
	 * to prompt the user.
	 * @return	Reader instance.
	 */
	public Reader getReader() {
		return commandReader;
	}
	
	/**
	 * @return	Server instance.
	 */
	public Server getServer() {
		return server;
	}
	
	/**
	 * @return	Whether the user is logged into an account or not.
	 */
	public boolean isLogged() {
		return (account != null);
	}
	
	/**
	 * Mark the program to do not get another command line from the user.
	 */
	public void stopExecution() {
		resumeProgram = false;
	}
	
	/**
	 * @return	Whether the program should get another command line.
	 */
	public boolean resumeExecution() {
		return resumeProgram;
	}
}
