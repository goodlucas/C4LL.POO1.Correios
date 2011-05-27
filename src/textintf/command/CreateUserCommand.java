package textintf.command;

/**
 *  Text terminal create user command. Create a new account and user.
 */
public final class CreateUserCommand extends TerminalCommand implements
		ICommandName {
	@Override
	public String getName() {
		return "newuser";
	}
	
	@Override
	public String getHelp() {
		return "Criar uma nova conta de usuário";
	}
}
