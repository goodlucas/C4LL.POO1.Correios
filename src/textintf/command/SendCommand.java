package textintf.command;

import java.util.ArrayList;
import java.util.List;

import textintf.Core;

import com.beust.jcommander.Parameter;

/**
 * Text terminal send command. Send a message for one or more accounts.
 */
public final class SendCommand extends TerminalCommand implements ICommand {
	@Parameter(description = "Lista de contas para enviar.")
	public List<String> destinations = new ArrayList<String>();

	@Override
	public String getName() {
		return "send";
	}

	@Override
	public String getHelp() {
		return "Escrever uma mensagem para um ou mais destinatários";
	}

	@Override
	public void execute(Core core) {
		// TODO Auto-generated method stub
		
	}
}
