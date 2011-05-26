package textintf;

import server.Server;
import command.*;

/**
 * End-user text interface. This class translate a command line into an
 * action in the post office program.
 */
public final class TextInterface {
	Reader	commandReader = new Reader();
	Server	server;
	
	public TextInterface(Server server) {
		this.server = server;  
	}
	
	private boolean nextLine() {
		TerminalCommand cmd = commandReader.readCommand();
		
		/* Command not found in CommandCollection */
		if (cmd == null) {
			System.out.println("O comando não existe. Digite help para ajuda.");
			return true;
		}
		/* Received --help option */
		if (cmd.help) {
			ShowCommandHelper.showHelp(((ICommandName) cmd).getName());
			return true;
		}
		
		if (cmd instanceof HelpCommand) {
			System.out.println("você digitou o comando help.");
			ShowCommandHelper.showCommands();
		}
		
		if (cmd instanceof LoginCommand) {
			
		}
		return true;
	}
	
	public void mainLoop() {
		boolean	resume = true;
		
		while (resume)
			resume = nextLine();
	}
}
