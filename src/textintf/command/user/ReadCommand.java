package textintf.command.user;

import java.util.ArrayList;
import java.util.List;

import textintf.Core;
import textintf.command.*;

import com.beust.jcommander.Parameter;

/**
 * Text terminal read command. Read a message by its ID.
 */
public final class ReadCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Número da mensagem. Aceita mais de um.")
	public List<Integer> ids = new ArrayList<Integer>();

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
		if (ids.isEmpty()) {
			System.out.print("Defina o id da mensagem a ser lida.");
			return;
		}
		
	}

	@Override
	public void setDefaultParameters() {
		ids.clear();
	}
}
