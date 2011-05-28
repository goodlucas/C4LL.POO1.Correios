package main;

import server.Server;
import textintf.TextInterface;

public final class Main {

	/**
	 * Main executation.
	 */
	public static void main(String[] args) {
		Server			server = new Server("unicentro.br");		
		TextInterface	intf = new TextInterface(server);
		
		intf.mainLoop();
	}

}
