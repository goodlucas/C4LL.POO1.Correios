package textintf.command;

/**
 * Help command. Show all available commands in the terminal.
 */
public class HelpCommand extends TerminalCommand implements ICommandName {
	@Override
	public String getName() {
		return "help";
	}

	@Override
	public String getHelp() {
		return "Mostra esta mensagem.";
	}
	
	/**
	 * "help --help" does not make point, so we do not allow this option.
	 */
	@Override
	public boolean allowHelpOption() {
		return false;
	}
}