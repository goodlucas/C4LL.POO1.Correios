package command;

import java.util.ArrayList;
import java.util.Scanner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Reader {
	private Scanner reader;
	
	/**
	 * Constructor. Create a Scanner to standard input.
	 */
	public Reader() {
		reader = new Scanner(System.in);
	}
	
	/**
	 * Read a command line and parse it by the command.
	 * @return TerminalCommand instance of the parsed line. Will be returned
	 * 		null in case of error like command not found of invalid parameter.
	 */
	public TerminalCommand readCommand() {
		String				raw = reader.nextLine();
		ArrayList<String> 	tokens = new ArrayList<String>();
		
		Scanner lineParser = new Scanner(raw);
		// Split line into tokens (Divided by ' ')
		while (lineParser.hasNext())
			tokens.add(lineParser.next());
		if (tokens.size() > 0)
			return processLine(tokens);
		else
			return null;
	}
	
	/**
	 * Proccess a readed line.
	 * @param list	Command line splitted by spaces into tokens.
	 * @return	Instance of TerminalCommand. (see readCommand)
	 */
	private TerminalCommand processLine(ArrayList<String> list) {
		String		command = list.get(0);
		
		list.remove(0);
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			if (((CommandName) tc).getName().equals(command)) {
				String[]	arg = new String[list.size()];
				
				try {
					new JCommander(tc, list.toArray(arg));
				} catch (ParameterException p) {
					System.out.println("** Erro ** " + p.getMessage());
					return null;
				}
				return tc;
			}
		}
		/* Should never be reached */
		return null;
	}
}
