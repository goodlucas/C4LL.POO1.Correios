package textintf.command;

import java.util.ArrayList;
import java.util.Scanner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * Reader class should be used to get a command line from user and
 * process, returning a TerminalCommand child class instance.
 */
public class Reader {
	private Scanner reader;
	
	/**
	 * Constructor. Create a Scanner to standard input.
	 */
	public Reader() {
		reader = new Scanner(System.in);
	}
	
	/**
	 * This method can be accessed from outside.
	 * @return	String with a new line from the input.
	 */
	public String getNextLine() {
		return reader.nextLine();
	}
	
	/**
	 * Print message before read a line.
	 * @param message	Message to be printed.
	 * @return	Readed line. Can result an empty line if user just press enter.
	 */
	public String ask(String message) {
		System.out.print(message);
		return getNextLine();
	}
	
	/**
	 * Print message and read a line until the response is not empty.
	 * @param message	Message to be printed.
	 * @return	Return non empty response.
	 */
	public String askNotEmpty(String message, String errorMessage) {
		String	response = "";
		while (response.isEmpty()) {
			response = ask(message);
			if (message.isEmpty() && errorMessage != null)
				System.out.println(errorMessage);
		}
		return response;
	}
	
	/**
	 * Read a command line and parse it by the command.
	 * @return TerminalCommand instance of the parsed line. Will be returned
	 * 		null in case of error like command not found of invalid parameter.
	 */
	public TerminalCommand readCommand() {
		String				raw = getNextLine();
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
	 * Proccess a readed line. The first word is the command name, the others
	 * should be processed as options and parameters to the command. After
	 * find a terminal command in the command collection that the getName
	 * equals to the received command, the instance of the terminal command
	 * will re-initialize the parameters and call the parameter parser.
	 * If and error to parse occur, the instace will be invalidated.
	 * @param list	Command line splitted by spaces into tokens.
	 * @return	Instance of TerminalCommand. (see readCommand)
	 */
	private TerminalCommand processLine(ArrayList<String> list) {
		String		command = list.get(0);
		
		list.remove(0);
		for (TerminalCommand tc: CommandCollection.COMMANDS) {
			if (tc.getName().equals(command)) {
				String[]	arg = new String[list.size()];
				
				try {
					tc.init();
					if (tc instanceof IHasParameters)
						((IHasParameters) tc).setDefaultParameters();
					new JCommander(tc, list.toArray(arg));
				} catch (ParameterException p) {
					System.out.println("** Erro  " + p.getMessage());
					tc.invalidate();
				}
				return tc;
			}
		}
		/* Should never be reached */
		return null;
	}
}
