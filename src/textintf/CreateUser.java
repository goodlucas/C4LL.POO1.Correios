package textintf;

import accounts.Account;
import accounts.AccountException;
import accounts.User;
import server.ServerException;
import textintf.command.Reader;

public final class CreateUser {
	CreateUser(TextInterface core) {
		askData(core);
	}
	
	private void askData(TextInterface core) {
		System.out.println("Digite as informações do novo usuário a seguir.");
		System.out.print("Nome de usuário: ");
		String	name = core.getReader().getNextLine();
		
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
