package command;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Text terminal inbox command. Handle messages in the inbox.
 */
public final class InboxCommand extends TerminalCommand implements CommandName {
	public static final String	NAME = "inbox";
	
	@Parameter(description = "Definir um filtro para a listagem")
	public List<String> filtros = new ArrayList<String>();
	
	@Parameter(names = {"-u", "--unread"}, 
			description = "Mostrar mensagens não lidas da caixa de entrada.")
	public boolean unread = false;
	
	@Parameter(names = {"-r", "--read"}, 
			description = "Mostrar mensagens lidas da caixa de entrada.")
	public boolean read = false;

	@Parameter(names = {"-a", "--all"}, 
			description = "Mostrar todas as mensagens da caixa de entrada.")
	public boolean all = true;

	@Override
	public String getName() {
		return NAME;
	}
}
