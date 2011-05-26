package command;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Text terminal delete command. Delete one or more messages by its IDs.
 */
public final class DeleteCommand extends TerminalCommand implements ICommandName {
	@Parameter(description = "Número da mensagem. Aceita mais de um.")
	public List<String> ids = new ArrayList<String>();

	@Override
	public String getName() {
		return "del";
	}

	@Override
	public String getHelp() {
		return "Deletar uma mensagem pelo seu id.";
	}
}
