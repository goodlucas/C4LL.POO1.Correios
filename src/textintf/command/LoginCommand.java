package textintf.command;

import server.ServerException;
import textintf.Core;

import accounts.Account;

import com.beust.jcommander.Parameter;

/**
 * Text terminal login command. Handle the login command, with password support.
 */
public class LoginCommand extends TerminalCommand 
	implements ICommand, IHasParameters {
	@Parameter(names = {"-u", "--user"}, 
			description = "Definir com qual usuário deseja logar.")
	public String login;

	@Override
	public String getName() {
		return "login";
	}

	@Override
	public String getHelp() {
		return "Logar em uma conta de usuário.";
	}
	
	@Override
	public boolean allowUnloggedUser() {
		return true;
	}

	@Override
	public void execute(Core core) {
		String	login = "", password;
		
		/* Get login name */
		if (this.login != null)
			login = this.login;
		else {
			while (login.isEmpty())
				login = core.getReader().ask("Nome do usuário: ");
		}
		/* Get password */
		password = core.getReader().ask("Senha: ");
		/* Log in the account */
		try {
			Account a = core.getServer().getAccount(login, password);
			if (a != null) {
				core.setAccount(a);
			} else {
				System.out.println("Usuário não cadastrado.");
			}
		} catch (ServerException e) {
			System.out.println("Erro: ");
		}
	}

	@Override
	public void setDefaultParameters() {
		login = null;
	}
}
