package textintf.command;

import java.util.ArrayList;
import java.util.List;

import textintf.Core;

import com.beust.jcommander.Parameter;

/**
 * Text terminal read command. Read a message by its ID.
 */
public final class ReadCommand extends TerminalCommand implements ICommand {
	@Parameter(description = "Número da mensagem. Aceita mais de um.")
	public List<String> ids = new ArrayList<String>();

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
		// TODO Auto-generated method stub
		
	}
}
