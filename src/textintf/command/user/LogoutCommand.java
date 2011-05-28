package textintf.command.user;

import textintf.Core;
import textintf.command.*;

public final class LogoutCommand extends TerminalCommand implements ICommand {
	@Override
	public String getName() {
		return "logout";
	}
	
	@Override
	public String getHelp() {
		return "Sair de uma conta";
	}

	@Override
	public void execute(Core core) {
		System.out.println("Você saiu da conta " + 
				core.getAccount().getLoginName() + ".");
		core.setAccount(null);
	}
}
