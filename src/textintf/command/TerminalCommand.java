package textintf.command;

import com.beust.jcommander.Parameter;

/**
 * Generic class for a terminal command.
 */
public abstract class TerminalCommand {
	/**
	 * All command accept --help option. When the getHelp() implemented method 
	 * of ICommandName interface returns null, no help will be showed. 
	 */
	@Parameter(names = {"--help"}, hidden = true)
	public boolean help;
	
	/**
	 * Get instance as ICommandName to allow get information about the class.
	 * @return The instance with Interface casting.
	 */
	public ICommand getCommand() {
		return (ICommand) this;
	}
	
	/**
	 * Allow to receive the option --help. Override this method returning false,
	 * to block --help option. When not allowed, a message saying that there
	 * is no help for the command should be showed.
	 * @return	Whether the --help option can be received.
	 */
	public boolean allowHelpOption() {
		return true;
	}
	
	/**
	 * Allow the command be called from an unlogged user. Override this method
	 * returning true to allow a command be called.
	 * @return	Whether the command can be used for an unlogged user.
	 */
	public boolean allowUnloggedUser() {
		return false;
	}
}
