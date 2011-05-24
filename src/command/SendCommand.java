package command;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Text terminal send command. Send a message for one or more accounts.
 */
public final class SendCommand extends TerminalCommand {
	public static final String	NAME = "send";
	
	@Parameter(description = "Lista de contas para enviar.")
	public List<String> destinations = new ArrayList<String>();
}
