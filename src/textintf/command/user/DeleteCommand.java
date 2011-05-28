package textintf.command.user;

import textintf.Core;
import textintf.command.*;

import com.beust.jcommander.Parameter;

/**
 * Text terminal delete command. Delete one or more messages by its IDs.
 */
public final class DeleteCommand extends TerminalCommand implements 
		ICommand, IHasParameters {
	@Parameter(description = 
				"Número das mensagens separados por espaço. Exemplo: del 2 3")
	public StringParameter ids = new StringParameter();

	@Override
	public String getName() {
		return "del";
	}

	@Override
	public String getHelp() {
		return "Deletar uma mensagem pelo seu id.";
	}

	@Override
	public void execute(Core core) {
		// TODO delete a message
	}

	@Override
	public void setDefaultParameters() {
		ids.clear();
	}
}
