package textintf.command.user;

import server.ServerException;
import textintf.Core;

import accounts.Account;
import textintf.command.*;

import com.beust.jcommander.Parameter;

/**
 * Text terminal login command. Handle the login command, with password support.
 */
public class LoginCommand extends TerminalCommand implements IHasParameters {
	@Parameter(description = "Nome do usuário")
	public StringParameter loginName = new StringParameter();
	
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
		if (loginName.isEmpty() == false)
			login = loginName.get(0);
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
				System.out.println("\tUsuário não cadastrado.");
			}
		} catch (ServerException e) {
			System.out.println("\tErro: " + e.getMessage());
		}
	}

	@Override
	public void setDefaultParameters() {
		loginName.clear();
	}
	
	@Override
	public boolean hideHelpForLoggedUser() {
		return true;
	}
}
