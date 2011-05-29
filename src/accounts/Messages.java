/**
 * 
 */
package accounts;

import java.util.ArrayList;

/**
 * Messages class is a list of Message instances (ArrayList).
 */
@SuppressWarnings("serial")
public final class Messages extends ArrayList<Message> {
	public static void printHeaders(Messages messageList) {
		for (Message m: messageList)
			System.out.println(m.toStringHeader());
	}

	public static void print(Messages messageList) {
		// TODO : Is it a necessary method?
		for (Message m: messageList)
			System.out.println(m);
	}
}
