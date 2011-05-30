package textintf.command;

import textintf.Core;
import textintf.command.user.*;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * Class for help-relationed information. This class have just static methods,
 * tough. 
 */
public final class ShowCommandHelper {
	/**
	 * Show help command for a given command.
	 * @param cmd	What command should get help.
	 */
	public static void showHelp(String cmd) {
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			if (tc.getName().equals(cmd)) {
				if (tc.allowHelpOption()) {
					try {
						JCommander	jcd = new JCommander(tc, "--help");
						jcd.setProgramName(tc.getName());
						jcd.usage();
					} catch (ParameterException p) {
						return;
					}
					return;
				}
			}
		}
		System.out.println("Não há ajuda para este comando.");
	}
	
	/**
	 * @return	String "command --help"
	 */
	private static String getExample() {
		return new InboxCommand().getName() + " --help";
	}
	
	/**
	 * Show avaiable commands. If the user is currently logged, all commands
	 * will be showed. Otherwise, only unlogged commands.
	 * @param core	Core instance.
	 */
	public static void showCommands(Core core) {
		System.out.println("Ajuda do programa " + core.getProgramName());
		System.out.println("Para ver a ajuda de um comando, use a opção --help");
		System.out.println("Exemplo: " + getExample());
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			String	name = tc.getName();
			String	help = tc.getHelp();
			
			if (help != null) {
				/* If user is not logged, will be printed only commands that
				 * the user can actually execute.
				 * If user is logged, will be printed commands that don't
				 * are hidden by the hideHelpForLoggedUser.
				 */
				if ((core.isLogged() && !tc.hideHelpForLoggedUser())
						|| (!core.isLogged() && tc.allowUnloggedUser())) {
					System.out.println("\t" + name + "\t" + help);
				}
			}
		}
		System.out.println("");
	}
}
