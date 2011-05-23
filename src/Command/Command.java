package Command;

import java.util.ArrayList;

/**
 * Class to store a command line info.
 * 
 * @author Paulo Urio
 */
public class Command {
	private String				name;
	private ArrayList<Option>	options;
	
	public Command(String commandLine) {
		options = new ArrayList<Option>();
		name = new String(commandLine).split(" ")[0];
		if (name.equals("inbox")) {
			new OptionParser().addOption("r", "read", false, "List read messages")
							  .addOption("u", "unread", false, "List unread messages")
							  .addOption("a", "all", false, "List all messages")
							  .parseString(commandLine, options);
		}
	}
	
//	public Command addOption(Option o) {
//		if (o != null)
//			options.add(o);
//		return this;
//	}
	
	public Option getOption(int index) {
		return options.get(index);
	}
	
	public int getOptionCount() {
		return options.size();
	}
	
	public String getName() {
		return name;
	}
}
