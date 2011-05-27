package textintf;

import accounts.Account;
import textintf.command.*;
import server.Server;

/**
 * End-user text interface. This class translate a command line into an
 * action in the post office program.
 */
public final class TextInterface {
	/* When a user is not logged, guest will be used instead. */
	private final String	GUEST_USER = "convidado";
	
	private Reader	commandReader = new Reader();
	private Server	server;
	private Account	account = null;
	
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
		System.out.print(getPromptUser() + "@" + server.getServerName() + 
				" $ ");
	}
	
	private void suggestHelp() {
		System.out.println("Digite " + new HelpCommand().getName() + 
				" para ajuda.");
	}
	
	private String getPromptUser() {
		if (isLogged()) {
			return account.getLoginName();
		} else {
			return GUEST_USER;
		}
	}
	
	private boolean isLogged() {
		return (account != null);
	}
	
	private boolean processCommand(TerminalCommand cmd) {
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
		
		/* From here, all commands are only accepted when the user
		 * is logged into an account. */
		if (!isLogged()) {
			System.out.println("Você precisa estar logado para executar " + 
					"esta operação.");
			suggestHelp();
			return true;
		}
		
		if (cmd instanceof LoginCommand) {
			
		}
		return true;
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
			System.out.println("O comando não existe.");
			suggestHelp();
			return true;
		}
		/* Received --help option */
		if (cmd.help) {
			ShowCommandHelper.showHelp(cmd.getCommand().getName());
			return true;
		}
		/* When reached here, the command should be processed */
		return processCommand(cmd);
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
