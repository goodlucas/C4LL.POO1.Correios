package textintf.command.user;

import java.util.ArrayList;

import textintf.Core;
import textintf.command.*;

import accounts.AccountException;
import accounts.Message;

import com.beust.jcommander.Parameter;

/**
 * Text terminal delete command. Delete one or more messages by its IDs.
 */
public final class DeleteCommand extends TerminalCommand implements 
		IHasParameters {
	@Parameter(description = 
				"Número das mensagens separados por espaço. Exemplo: del 2 3")
	public ArrayList<Integer> ids = new ArrayList<Integer>();

	@Override
	public String getName() {
		return "del";
	}

	@Override
	public String getHelp() {
		return "Deletar uma mensagem pelo seu id.";
	}

	@Override
	public void execute(Core core) {
		if (ids.isEmpty()) {
			System.out.print("\tDefina o id da mensagem a ser lida.");
			return;
		}
		for (Integer id: ids) {
			Message m = core.getAccount().getMessage(id);
			/* Try to move the message to the trash. */
			try {
				core.getAccount().moveToTrash(m);
				System.out.println("\tMensagem com id " + id + " movida para"
						+ " a lixeira.");
			} catch (AccountException e) {
				System.out.println("\tErro ao deletar mensagem com id " + id
						+ ": " + e.getMessage());
			}
		}
	}

	@Override
	public void setDefaultParameters() {
		ids.clear();
	}
}
