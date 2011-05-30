package textintf.command.user;

import server.ServerException;
import textintf.Core;

import accounts.Message;

import com.beust.jcommander.Parameter;
import textintf.command.*;

/**
 * Text terminal send command. Send a message for one or more accounts.
 */
public final class SendCommand extends TerminalCommand 
	implements IHasParameters {
	@Parameter(description = "Passe a lista de contas para enviar separadas por espaço.")
	public StringParameter destinations = new StringParameter();

	@Override
	public String getName() {
		return "send";
	}

	@Override
	public String getHelp() {
		return "Escrever uma mensagem para um ou mais destinatários "
				+ "(separe com espaço)";
	}

	@Override
	public void execute(Core core) {
		try {
			String	to = null;
			
			if (destinations.isEmpty()) 
				to = core.getReader().askNotEmpty("Destino (apenas um): ", 
						"Defina o destinatário.");
			Message	m = new Message(core.getAccount().getLoginName(), null,
				core.getReader().ask("Assunto: "), 
				core.getReader().ask("Conteúdo: \n"), false);
			if (!destinations.isEmpty())
				m.addDestinations(destinations.toDestinationList());
			else
				m.addDestination(to);
			core.getAccount().send(m);
			System.out.println("Mensagem criada com sucesso!");
		} catch (ServerException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	@Override
	public void setDefaultParameters() {
		destinations.clear();
	}
}
