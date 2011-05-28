package textintf.command;

import textintf.Core;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public final class ShowCommandHelper {
	public static void showHelp(String cmd) {
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			if (tc.getCommand().getName().equals(cmd)) {
				if (tc.allowHelpOption()) {
					try {
						JCommander	jcd = new JCommander(tc, "--help");
						jcd.setProgramName(tc.getCommand().getName());
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
	
	private static String getExample() {
		return new InboxCommand().getName() + " --help";
	}
	
	public static void showCommands(Core core) {
		System.out.println("Ajuda do programa PostOffice");
		System.out.println("Para ver a ajuda de um comando, use a opção --help");
		System.out.println("Exemplo: " + getExample());
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			String	name = tc.getCommand().getName();
			String	help = tc.getCommand().getHelp();
			
			if (help != null) {
				/* If user is not logged, will be printed only commands that
				 * the user can actually execute.
				 */
				if (core.isLogged() 
						|| (!core.isLogged() && tc.allowUnloggedUser())) {
					System.out.println("\t" + name + "\t" + help);
				}
			}
		}
		// TODO : Should print an empty line at end? Just like usage()
	}
}
