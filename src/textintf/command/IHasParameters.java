package textintf.command;

/**
 * Base interface for commands that have parameters defined.
 */
public interface IHasParameters {
	/**
	 * Method called to uptade default parameters. This is necessary because
	 * the instance of each command will be all along the program. Therefore,
	 * if you use a command two times, at second time all parameters would be
	 * how the first time let.
	 */
	public void setDefaultParameters();
}
