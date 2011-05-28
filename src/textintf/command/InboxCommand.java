package textintf.command;

import java.util.ArrayList;
import java.util.List;

import textintf.Core;

import com.beust.jcommander.Parameter;

/**
 * Text terminal inbox command. Handle messages in the inbox.
 */
public final class InboxCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Definir um filtro para a listagem")
	public List<String> filtros = new ArrayList<String>();
	
	@Parameter(names = {"-u", "--unread"}, 
			description = "Mostrar mensagens não lidas da caixa de entrada.")
	public boolean unread;
	
	@Parameter(names = {"-r", "--read"}, 
			description = "Mostrar mensagens lidas da caixa de entrada.")
	public boolean read;

	@Parameter(names = {"-a", "--all"}, 
			description = "Mostrar todas as mensagens da caixa de entrada.")
	public boolean all;

	@Override
	public String getName() {
		return "inbox";
	}

	@Override
	public String getHelp() {
		return "Listar mensagens na caixa de entrada.";
	}

	@Override
	public void execute(Core core) {
		// TODO show inbox.
	}

	@Override
	public void setDefaultParameters() {
		filtros.clear();
		unread = false;
		read = false;
		all = false;
	}
}
