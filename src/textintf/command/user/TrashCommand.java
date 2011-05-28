package textintf.command.user;

import textintf.Core;
import textintf.command.*;

import com.beust.jcommander.Parameter;

/**
 * Text terminal trash command. Handle messages in the trash.
 */
public final class TrashCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Filtro de mensagem")
	public StringParameter filtros = new StringParameter();

	@Parameter(names = {"-c", "--clear"}, description = "Esvaziar lixeira.")
	public boolean clear;

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
		// TODO trash command
	}

	@Override
	public void setDefaultParameters() {
		filtros.clear();
		clear = false;
	}
}

