package textintf.command.user;

import textintf.Core;
import textintf.command.*;

import accounts.Messages;

import com.beust.jcommander.Parameter;

/**
 * Text terminal inbox command. Handle messages in the inbox.
 */
public final class InboxCommand extends TerminalCommand 
	implements IHasParameters {
	@Parameter(description = "Definir um filtro para a listagem")
	public StringParameter filtros = new StringParameter();
	
	@Parameter(names = {"-u", "--unread"}, 
			description = "Mostrar mensagens não lidas da caixa de entrada.")
	public boolean unread;
		
	@Parameter(names = {"-r", "--read"}, 
			description = "Mostrar mensagens lidas da caixa de entrada.")
	public boolean read;

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
		Messages	msgs;
		boolean		all = !read && !unread;
		
		msgs = core.getAccount().getInbox(filtros.toString(), read || all, 
				unread || all);
		if (msgs.isEmpty()) {
			System.out.println("\tCaixa de entrada vazia.");
			return;
		}
		/* Print the count of messages, and then its headers. */
		if (msgs.size() == 1)
			System.out.println("\t1 mensagem");
		else
			System.out.println("\t" + msgs.size() + " mensagens");
		Messages.printHeaders(msgs);
	}

	@Override
	public void setDefaultParameters() {
		filtros.clear();
		unread = false;
		read = false;
	}
}
