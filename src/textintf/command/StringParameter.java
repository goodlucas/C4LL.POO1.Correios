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
	/**
	 * Join the StringParameter with spaces.
	 */
	@Override
	public String toString() {
		return StringUtils.joinList(this, " ");
	}
	
	/**
	 * Convert StringParameter to an instance of DestinationList. Both
	 * classes extends from ArrayList<String>, though Java does not allow
	 * a casting between them. A copy of each String item had to be done.
	 * @return	DestinationList instance with same content of the 
	 * 			StringParameter instance.
	 */
	public DestinationList toDestinationList() {
		DestinationList list = new DestinationList();
		
		for (String p: this)
			list.add(p);
		return list;
	}
}
