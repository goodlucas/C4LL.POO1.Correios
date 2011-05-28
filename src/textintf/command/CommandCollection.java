package textintf.command;

import textintf.command.user.*;

/**
 * Store all command instances. When the help command is received, and help
 * of all command will be shown. These commands will be printed in the same
 * order of the COMMANDS array.
 */
public final class CommandCollection {
	public static final	TerminalCommand[]	COMMANDS = {
		new HelpCommand(),
		new CreateUserCommand(),
		new LoginCommand(), 
		new InboxCommand(), 
		new TrashCommand(),
		new ReadCommand(), 
		new SendCommand(),
		new DeleteCommand(),
		new LogoutCommand(),
		new ExitCommand()
	};
}
