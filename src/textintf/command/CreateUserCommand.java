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
	public boolean allowUnloggedUser() {
		return true;
	}

	@Override
	public void execute(Core core) {
		System.out.println("Digite as informações do novo usuário a seguir.");
		System.out.print("Nome de usuário: ");
		String	name = core.getReader().getNextLine();
		// TODO: Do not allow an empty user
		
		System.out.print("Senha: ");		
		String	password = core.getReader().getNextLine();
		
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
