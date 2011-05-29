package textintf.command.user;

import textintf.Core;
import textintf.command.*;

import accounts.Messages;

import com.beust.jcommander.Parameter;

/**
 * Text terminal inbox command. Handle messages in the inbox.
 */
public final class InboxCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Definir um filtro para a listagem")
	public StringParameter filtros = new StringParameter();
	
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
		Messages msgs;
		
		msgs = core.getAccount().getInbox(filtros.toString(), read, unread);
		if (msgs.isEmpty()) {
			System.out.println("\tCaixa de entrada vazia.");
			return;
		}
		if (msgs.size() == 1)
			System.out.print("\t1 mensagem");
		else
			System.out.println("\t" + msgs.size() + " mensagens");
		Messages.printHeaders(msgs);
	}

	@Override
	public void setDefaultParameters() {
		filtros.clear();
		unread = false;
		read = false;
		all = false;
	}
}
