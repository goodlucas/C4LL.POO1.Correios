package textintf.command.user;

import textintf.Core;
import textintf.command.*;

import com.beust.jcommander.Parameter;

/**
 * Text terminal read command. Read a message by its ID.
 */
public final class ReadCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Número da mensagem. Aceita mais de um.")
	public StringParameter ids = new StringParameter();

	@Override
	public String getName() {
		return "read";
	}

	@Override
	public String getHelp() {
		return "Ler uma mensagem pelo seu id.";
	}

	@Override
	public void execute(Core core) {
		// TODO read a messsage
	}

	@Override
	public void setDefaultParameters() {
		ids.clear();
	}
}
