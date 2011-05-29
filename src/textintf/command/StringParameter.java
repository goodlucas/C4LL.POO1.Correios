package textintf.command;

import java.util.ArrayList;

import accounts.DestinationList;

import util.StringUtils;

/**
 * String parameter received from the command line.
 * Handle main parameters. For instance "command bla bla", the class
 * will store "bla bla" into an ArrayList, and toString() will join to
 * "bla bla".
 */
@SuppressWarnings("serial")
public final class StringParameter extends ArrayList<String> {
	@Override
	public String toString() {
		return StringUtils.joinList(this, " ");
	}
	
	public DestinationList toDestinationList() {
		DestinationList list = new DestinationList();
		
		for (String p: this)
			list.add(p);
		return list;
	}
}
