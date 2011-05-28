package textintf.command;

import textintf.Core;

/**
 * Base interface for a command. Every command class must implement this
 * interface, otherwise an exception will be throwed.
 */
public interface ICommand {
	/**
	 * @return	The command name.
	 */
	public String getName();
	
	/**
	 * @return	Brief explanation of what the command does.
	 */
	public String getHelp();
	
	/**
	 * Command execution. When user type the command relationed to the class,
	 * all parameters are valid, and if allowUnloggedUser() allow the run,
	 * the method execute() will be called.
	 * @param core	Instance to the TextInterface. Information like
	 * 					the server and the console reader can be accessed.
	 */
	public void execute(Core core);
}
