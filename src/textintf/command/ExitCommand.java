package textintf.command;

/**
 * Exit command. Finalize program.
 */
public class ExitCommand extends TerminalCommand implements ICommand {
	@Override
	public String getName() {
		return "exit";
	}

	@Override
	public String getHelp() {
		return "Sair do programa.";
	}
	
	/**
	 * "help --help" does not make point, so we do not allow this option.
	 */
	@Override
	public boolean allowHelpOption() {
		return false;
	}
	
	@Override
	public boolean allowUnloggedUser() {
		return true;
	}
}