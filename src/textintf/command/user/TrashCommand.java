package textintf.command.user;

import textintf.Core;
import textintf.command.*;

import accounts.Messages;

import com.beust.jcommander.Parameter;

/**
 * Text terminal trash command. Handle messages in the trash.
 */
public final class TrashCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(description = "Filtro de mensagem")
	public StringParameter filter = new StringParameter();

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
		/* Clear trash */
		if (clear) {
			if (core.getAccount().isTrashEmpty()) {
				System.out.println("\tNão há mensagens na lixeira.");
				return;
			}
			int count = core.getAccount().clearTrash();
			if (count == 1)
				System.out.println("\tFoi apagada uma mensagem.");
			else
				System.out.println("\tForam apagadas " + count + " mensagens");
			return;
		}
		/* See trash */
		Messages	msgs;
		msgs = core.getAccount().getTrash(filter.toString(), true, true);
		if (msgs.isEmpty()) {
			System.out.println("\tLixeira vazia.");
			return;
		}		
		Messages.printHeaders(core.getAccount().getTrash(filter.toString(), true, true));
	}

	@Override
	public void setDefaultParameters() {
		filter.clear();
		clear = false;
	}
}

