package textintf.command.user;

import textintf.Core;

import com.beust.jcommander.Parameter;
import textintf.command.*;

/**
 * Text terminal send command. Send a message for one or more accounts.
 */
public final class SendCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Lista de contas para enviar.")
	public StringParameter destinations = new StringParameter();

	@Override
	public String getName() {
		return "send";
	}

	@Override
	public String getHelp() {
		return "Escrever uma mensagem para um ou mais destinatários "
				+ "(separe com espaço)";
	}

	@Override
	public void execute(Core core) {
		// TODO send a message
	}

	@Override
	public void setDefaultParameters() {
		destinations.clear();
	}
}
