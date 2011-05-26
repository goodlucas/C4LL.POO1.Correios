package command;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Text terminal read command. Read a message by its ID.
 */
public final class ReadCommand extends TerminalCommand implements ICommandName {
	public static final String	NAME = "read";
	
	@Parameter(description = "Número da mensagem. Aceita mais de um.")
	public List<String> ids = new ArrayList<String>();

	@Override
	public String getName() {
		return NAME;
	}
}
