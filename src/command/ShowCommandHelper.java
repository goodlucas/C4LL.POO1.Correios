package command;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public final class ShowCommandHelper {
	public static void showHelp(String cmd) {
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			if (((ICommandName) tc).getName().equals(cmd)) {
				try {
					JCommander	jcd = new JCommander(tc, "--help");
					jcd.usage();
				} catch (ParameterException p) {
					return;
				}
				return;
			}
		}
	}
}
