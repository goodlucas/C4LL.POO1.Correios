package textintf.command.user;

import textintf.Core;
import textintf.command.*;

/**
 * Exit command. Finalize program.
 */
public class ExitCommand extends TerminalCommand {
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

	@Override
	public void execute(Core core) {
		System.out.println("Obrigado por usar o " + core.getProgramName() + "!");
		core.stopExecution();
	}
}