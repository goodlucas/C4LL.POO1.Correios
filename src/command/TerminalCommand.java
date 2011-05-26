/**
 * 
 */
package command;

import com.beust.jcommander.Parameter;

/**
 * Generic class for a terminal command.só.
 */
public abstract class TerminalCommand {
	@Parameter(names = {"--help"})
	public boolean help = false;
}
