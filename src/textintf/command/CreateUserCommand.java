package textintf.command;

import accounts.Account;
import accounts.AccountException;
import accounts.User;
import server.ServerException;
import textintf.Core;

/**
 *  Text terminal create user command. Create a new account and user.
 */
public final class CreateUserCommand extends TerminalCommand implements
		ICommand {
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
		System.out.println("Digite as informações do novo usuário a seguir.");
		String	name = "";
		while (name.isEmpty()) {
			name = core.getReader().ask("Nome de usuário: ");
			if (name.isEmpty())
				System.out.println("O nome do usuário não pode ser vazio.");
		}
		
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
}
