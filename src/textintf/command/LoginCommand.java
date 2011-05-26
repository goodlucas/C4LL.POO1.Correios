package textintf.command;

import com.beust.jcommander.Parameter;

/**
 * Text terminal login command. Handle the login command, with password support.
 */
public class LoginCommand extends TerminalCommand implements ICommandName {
	@Parameter(names = {"-u", "--user"}, 
			description = "Definir com qual usuário deseja logar.")
	public String login = null;
	
	@Parameter(names = {"-p", "--password"}, 
			description = "Logar com senha (Digitar somente quando pedir).",
			password = true)	
	public String password = null;

	@Override
	public String getName() {
		return "login";
	}

	@Override
	public String getHelp() {
		return "Logar em uma conta de usuário.";
	}
}