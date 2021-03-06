package textintf.command.user;

import textintf.Core;
import textintf.command.*;

/**
 * Help command. Show all available commands in the terminal.
 */
public class HelpCommand extends TerminalCommand {
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
	
	@Override
	public boolean allowUnloggedUser() {
		return true;
	}

	@Override
	public void execute(Core core) {
		ShowCommandHelper.showCommands(core);
	}
}