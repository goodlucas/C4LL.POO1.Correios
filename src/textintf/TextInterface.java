package textintf;

import textintf.command.*;
import textintf.command.user.*;
import server.Server;

/**
 * End-user text interface. This class translate a command line into an
 * action in the post office program.
 */
public final class TextInterface {
	/* When an user is not logged, guest will be used instead. */
	private final	String	GUEST_USER = "convidado";
	private 		Core	core;
		
	/**
	 * @param server	Server instance to be used.
	 */
	public TextInterface(Server server) {
		core = new Core(server);  
	}
	
	/**
	 * Print into the console the welcome message.
	 */
	private void showWelcomeMessage() {
		System.out.println("Bem vindo ao " + core.getProgramName() + "!");
		System.out.println("Para ajuda digite " + new HelpCommand().getName());
		System.out.println("");
	}
	
	/**
	 * Print into the console the prompt message.
	 * The format is:
	 * 		user@server.name $ 
	 * If there is not user, 'guest' should be used instead.
	 */
	private void printPrompt() {
		String	user = getPromptUser();
		String	prompt = core.getServer().getUserAddress(user) + " $ ";
		System.out.print(prompt);
	}
	
	/**
	 * Print a suggest to how to get help of program usage.
	 */
	private void suggestHelp() {
		String help = "Digite " + new HelpCommand().getName() + " para ajuda.";
		System.out.println(help);
	}
	
	/**
	 * @return Current logged user. GUEST_USER const will be returned when
	 * 			no user is logged.
	 */
	private String getPromptUser() {
		if (core.isLogged()) {
			return core.getAccount().getLoginName();
		} else {
			return GUEST_USER;
		}
	}
	
	/**
	 * Dispatch a command. This dispatch is did by calling execute() method
	 * on the command instance.
	 * @param cmd	The received command.
	 */
	private void processCommand(TerminalCommand cmd) {
		if (!core.isLogged() && !cmd.allowUnloggedUser()) {
			System.out.println("Você precisa estar logado para executar " + 
					"esta operação.");
			suggestHelp();
		} else {
			cmd.execute(core);
		}
	}
	
	/**
	 * Get a command line from the user and process.
	 * @return	True ff the program should read a next line, false to exit.
	 */
	private void nextLine() {
		TerminalCommand	cmd; 
		
		printPrompt();
		cmd = core.getReader().readCommand();		
		/* Command not found in CommandCollection */
		if (cmd == null) {
			System.out.println("O comando não existe.");
			suggestHelp();
			return;
		}
		/* Check if there was any error to get the parameters. */
		if (!cmd.isValid())
			return;
		/* Received --help option */
		if (cmd.help) {
			ShowCommandHelper.showHelp(cmd.getName());
			return;
		}
		/* When reached here, the command should be processed */
		processCommand(cmd);
	}
	
	/**
	 * Main loop to process command line type from the user.
	 */
	public void mainLoop() {
		showWelcomeMessage();
		while (core.resumeExecution())
			nextLine();
	}
}
