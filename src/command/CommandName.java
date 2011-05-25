package command;

/**
 * Base interface for a command. Every command class must implement this
 * interface, otherwise an exception will be throwed.
 */
public interface CommandName {
	public String getName();
}
