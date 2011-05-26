package command;

/**
 * Base interface for a command. Every command class must implement this
 * interface, otherwise an exception will be throwed.
 */
public interface ICommandName {
	/**
	 * @return	The command name.
	 */
	public String getName();
	
	/**
	 * @return	Brief explanation of what the command does.
	 */
	public String getHelp();
}
