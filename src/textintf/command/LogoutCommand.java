package textintf.command;

public final class LogoutCommand extends TerminalCommand implements
		ICommandName {
	@Override
	public String getName() {
		return "logout";
	}
	
	@Override
	public String getHelp() {
		return "Sair de uma conta";
	}
}
