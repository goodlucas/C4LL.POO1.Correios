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
	/**
	 * Print the headers of a list of messages.
	 * @param messageList	The list of messages.
	 */
	public static void printHeaders(Messages messageList) {
		for (Message m: messageList)
			System.out.println(m.toStringHeader());
	}
	
	/**
	 * Print an entire message.
	 * @param message	The message.
	 */
	public static void print(Message message) {
		System.out.println(message);
	}

	/**
	 * Print entire messages
	 * @param messageList List of messages to be printed.
	 */
	public static void print(Messages messageList) {
		for (Message m: messageList)
			print(m);
	}	
}
