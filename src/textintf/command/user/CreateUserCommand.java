package textintf.command.user;

import com.beust.jcommander.Parameter;

import accounts.Account;
import accounts.AccountException;
import accounts.User;
import server.ServerException;
import textintf.Core;
import textintf.command.*;

/**
 *  Text terminal create user command. Create a new account and user.
 */
public final class CreateUserCommand extends TerminalCommand implements
		ICommand, IHasParameters {
	@Parameter(description = "Nome do usuário")
	public StringParameter newName = new StringParameter();
	
	@Override
	public String getName() {
		return "newuser";
	}
	
	@Override
	public String getHelp() {
		return "Criar uma nova conta de usuário";
	}
	
	@Override
	public boolean allowHelpOption() {
		return false;
	}	
	
	@Override
	public boolean allowUnloggedUser() {
		return true;
	}

	@Override
	public void execute(Core core) {
		final String USER_NAME = "Nome do usuário: ";
		String	name = "";

		System.out.println("Digite as informações do novo usuário a seguir.");
		/* Get new login name */
		if (newName.isEmpty() == false) {
			name = newName.get(0);
			System.out.println(USER_NAME + name);
		} else {
			while (name.isEmpty()) {
				name = core.getReader().ask(USER_NAME);
				if (name.isEmpty())
					System.out.println("O nome do usuário não pode ser vazio.");
			}
		}
		/* Get new password */
		String	password = core.getReader().ask("Senha: ");
		
		User	user = new User(name, password);
		try {
			new Account(core.getServer(), user);
			System.out.println("Usuário cadastrado com sucesso!");
		} catch (ServerException e) {
			System.out.println("Erro do servidor: " + e.getMessage());
		} catch (AccountException e) {
			System.out.println("Erro ao criar conta: " + e.getMessage());
		}	
	}

	@Override
	public void setDefaultParameters() {
		newName.clear();
	}
}