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
	
	/**
	 * @param server	Server instance to be used.
	 */
	public TextInterface(Server server) {
		this.server = server;  
	}
	
	/**
	 * Print on the stdout the welcome message.
	 */
	private void showWelcomeMessage() {
		System.out.println("Bem vindo ao PostOffice!");
		System.out.println("Para ajuda digite " + new HelpCommand().getName());
		System.out.println("");
	}
	
	/**
	 * Print on the stdout the prompt message.
	 * The format is:
	 * 		user@server.name $ 
	 * If there is not user, 'guest' should be used instead.
	 */
	private void printPrompt() {
		System.out.print("TODO" + "@" + server.getServerName() + " $ ");
		// TODO : Get user name
	}
	
	/**
	 * Get a command line from the user and process.
	 * @return	True ff the program should read a next line, false to exit.
	 */
	private boolean nextLine() {
		TerminalCommand	cmd; 
		
		printPrompt();
		cmd = commandReader.readCommand();		
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
		/* Help command */
		if (cmd instanceof HelpCommand) {
			ShowCommandHelper.showCommands();
			return true;
		}
		/* Exit command */
		if (cmd instanceof ExitCommand) {
			System.out.println("Tchau!");
			return false;
		}
		
		if (cmd instanceof LoginCommand) {
			
		}
		return true;
	}
	
	/**
	 * Main loop to process command line type from the user.
	 */
	public void mainLoop() {
		boolean	resume = true;
		
		showWelcomeMessage();
		while (resume)
			resume = nextLine();
	}
}
