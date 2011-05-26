package main;

import server.Server;
import textintf.TextInterface;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Reader rd = new Reader();
//		
//		TerminalCommand recv = rd.readCommand();
//		
//		if (recv instanceof InboxCommand) {
//			InboxCommand	ic = (InboxCommand) recv;
//			
//			System.out.println("--all = " + ic.all);
//			System.out.println("--read = " + ic.read);
//			System.out.println("--unread = " + ic.unread);
//			System.out.println("Filtros: " + ic.filtros.toString());
//		} else {
//			System.out.println("Algo deu errado!");
//		}
		Server			server = new Server("unicentro.br");		
		TextInterface	intf = new TextInterface(server);
		
		intf.mainLoop();
	}

}
