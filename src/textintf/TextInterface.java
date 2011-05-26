package textintf;

import command.*;

/**
 * End-user text interface. This class translate a command line into an
 * action in the post office program.
 */
public final class TextInterface {
	Reader	commandReader = new Reader();
	
	public TextInterface() {
		
	}
	
	private boolean nextLine() {
		TerminalCommand cmd = commandReader.readCommand();
		
		if (cmd == null) {
			System.out.println("O comando não existe. Digite help para ajuda.");
			return true;
		}
		
		if (cmd.help) {
			ShowCommandHelper.showHelp(((ICommandName) cmd).getName());
			return true;
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
