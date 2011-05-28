package main;

import accounts.*;
import server.Server;
import server.ServerException;
import textintf.TextInterface;

public final class Main {

	/**
	 * Main executation.
	 */
	public static void main(String[] args) {
		Server			server = new Server("unicentro.br");		
		TextInterface	intf = new TextInterface(server);
		
		try {
			new Account(server, new User("jimmy", ""));
			new Account(server, new User("purio", ""));
			new Account(server, new User("e", ""));
		} catch (ServerException e) {
		} catch (AccountException e) {
		}
		
		intf.mainLoop();
	}

}
