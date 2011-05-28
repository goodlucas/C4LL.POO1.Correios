package textintf.command;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Text terminal delete command. Delete one or more messages by its IDs.
 */
public final class DeleteCommand extends TerminalCommand implements ICommand {
	@Parameter(description = 
				"Número das mensagens separados por espaço. Exemplo: del 2 3")
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
