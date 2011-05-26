package textintf.command;

/**
 * Store all command instances.
 */
public final class CommandCollection {
	public static final	TerminalCommand[]	COMMANDS = {
		new HelpCommand(),
		new LoginCommand(), 
		new InboxCommand(), 
		new TrashCommand(),
		new ReadCommand(), 
		new SendCommand(),
		new DeleteCommand(),
		new ExitCommand()
	};
}