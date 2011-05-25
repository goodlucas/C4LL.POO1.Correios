package command;

/**
 * Store all command instances.
 */
public final class CommandCollection {
	public static final	TerminalCommand[]	COMMANDS = {
		new DeleteCommand(), 
		new InboxCommand(), 
		new LoginCommand(), 
		new ReadCommand(), 
		new SendCommand(),
		new TrashCommand()
	};
}
