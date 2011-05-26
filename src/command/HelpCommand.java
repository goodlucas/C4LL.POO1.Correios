package command;

/**
 * Text terminal login command. Handle the login command, with password support.
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