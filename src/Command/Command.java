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
	
	Command(String name) {
		this.name = name;
		options = new ArrayList<Option>();
	}
	
	public Command addOption(Option o) {
		if (o != null)
			options.add(o);
		return this;
	}
	
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
