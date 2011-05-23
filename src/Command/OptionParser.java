package Command;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to parse a line into options.
 * Each option have a small and long option:
 * 
 * Example:
 * 	addOption("n", "name", true, "Name of the new user")
 * 
 * 	Help:
 * 		-n	--name		Name of the new user
 *  Parse syntax:
 *  	-n Paulo
 *  	--name=Paulo
 *  	An Option class instance should be created:
 *  		Option( acceptsParameter = true;
 *  				name = "name";
 *  				parameter = "Paulo" )
 * 
 * @author Paulo Roberto Urio
 *
 */
public class OptionParser {
	
	private class OptionInfo {
		String	arg;
		String	longArg;
		boolean	acceptParam;
		String	helpMessage;
		OptionInfo(String arg, String longArg, boolean acceptParam,
				String helpMessage) {
			this.arg = arg;
			this.longArg = longArg;
			this.acceptParam = acceptParam;
			this.helpMessage = helpMessage;
		}
	}
	
	private ArrayList<OptionInfo>	optList;
	
	OptionParser() {
		optList = new ArrayList<OptionInfo>();
	}
	
	public OptionParser addOption(String arg, String longArg, 
				boolean acceptParam, String helpMessage) {
		optList.add(new OptionInfo(arg, longArg, acceptParam, helpMessage));
		return this;
	}
	
	/**
	 * Parse a Command String.
	 * @param raw
	 * @param optList
	 * @return The count of parameters
	 */
	public int parseString(String raw, ArrayList<Option> optList) {
		Scanner	lineParser = new Scanner(raw);
		String	name = null;	
		
		// Parse entire line command
		while (lineParser.hasNext()) {
			String	token = lineParser.next();
			String	arg = null;
		
			if (name == null) { // Update the command name, go to next.
				name = token;
				continue;
			}
			if (token.startsWith("--")) {
				arg = token.substring(2);
			} else {
				if (token.startsWith("-")) { 
					arg = token.substring(1);
				} else {
					// Token does not start with '-' either '--'
					System.out.println("Unrecognized parameter %s. Use --help to get help.");
					continue; // TODO: Continue? Should it abort?
				}
			}
			if (arg != null)
				System.out.println("Processing " + arg);
			else
				System.out.print("No args");
			if (arg.equals("help")) {
				// TODO: Show help and quit.
			} 
			
		}
		return 0;
	}
}
