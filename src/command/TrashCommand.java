package command;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Text terminal trash command. Handle messages in the trash.
 */
public final class TrashCommand extends TerminalCommand implements ICommandName {
	public static final String	NAME = "trash";
	
	@Parameter(description = "Filtro de mensagem")
	public List<String> filtros = new ArrayList<String>();

	@Parameter(names = {"-c", "--clear"}, description = "Esvaziar lixeira.")
	public boolean clear = false;

	@Override
	public String getName() {
		return NAME;
	}
}

