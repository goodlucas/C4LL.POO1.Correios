package textintf.command;

import java.util.ArrayList;
import java.util.List;
import textintf.Core;

import com.beust.jcommander.Parameter;

/**
 * Text terminal trash command. Handle messages in the trash.
 */
public final class TrashCommand extends TerminalCommand implements ICommand {
	@Parameter(description = "Filtro de mensagem")
	public List<String> filtros = new ArrayList<String>();

	@Parameter(names = {"-c", "--clear"}, description = "Esvaziar lixeira.")
	public boolean clear = false;

	@Override
	public String getName() {
		return "trash";
	}

	@Override
	public String getHelp() {
		return "Listar (ou deletar) mensagens na lixeira.";
	}

	@Override
	public void execute(Core core) {
		// TODO Auto-generated method stub
		
	}
}

