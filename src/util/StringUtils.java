package util;

import java.util.ArrayList;

/**
 * Static string utils.
 * @author Paulo Urio
 */
public final class StringUtils {
	/**
	 * Join an ArrayList into a String. For instance: 
	 * StringUtils.joinList(new String[] {"Hello", "World", "!"}, ", ")
	 * will return "Hello, World, !"
	 * @param l			ArrayList of strings.
	 * @param joinString	String that join each string in the ArrayList
	 * @return	string with joined list. Empty string if ArrayList empty.
	 */
	public static String joinList(ArrayList<String> l, String joinString) {
		String 	toReturn = "";
		boolean	first = true;
		
		for (String param: l) {
			if (!first)
				toReturn += joinString;
			else
				first = false;
			toReturn += param;
		}
		return toReturn;		
	}
}
