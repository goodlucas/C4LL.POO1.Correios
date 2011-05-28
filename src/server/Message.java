package server;

import java.util.ArrayList;
import java.util.Date;


/**
 * Message information. It will store information about from where and to whom
 * the message is, the content, the post date, and if the message was read.
 */
public class Message {
	/**
	 * Sender user's login name.
	 */
	private String		from;
	/**
	 * Destination users' login names. A message can have one or more
	 * destination.
	 */
	private ArrayList<String>	to;
	/**
	 * Message content.
	 */
	private String		content;
	/**
	 * Sent date.
	 */
	private long		postDate;
	/**
	 * Store whether the message is marked as read or not.
	 */
	private Boolean		isRead;

	/**
	 * 
	 * @param from		Login name of the sender.
	 * @param to		Login name of the destination. This constructor accepts
	 * 					at most one destination. More should be added with
	 * 					addDestination method.
	 * @param content	Message content.
	 * @param read		Whether the message should be marked as read or not.
	 */
	public Message(String from, String to, String content, Boolean read) 
			throws ServerException {
		this.from = from;
		this.to = new ArrayList<String>();
		if (to != null)
			this.addDestination(to);
		this.content = content;
		this.isRead = read;
	}

	/**
	 * @return	The server user name.
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param loginName	Set the sender user name.
	 */
	public void setFrom(String loginName) {
		this.from = loginName;
	}

	/**
	 * @return	A list of the message's destination.
	 */
	public ArrayList<String> getDestinations() {
		return to;
	}

	/**
	 * Add a message destination.
	 * @param loginName	Destination login name.
	 * @throws ServerException	When the login is already as a destination.
	 */
	public void addDestination(String loginName) throws ServerException {
		if (to.contains(loginName))
			throw new ServerException("Destino duplicado: " + loginName);
		this.to.add(loginName);
	}

	/**
	 * @return	the text message. 
	 */
	public String getGetContent() {
		return content;
	}

	/**
	 * @param content	The new text message.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return Whether the message has been marked as read or not.
	 */
	public Boolean getIsRead() {
		return isRead;
	}

	/**
	 * Mark a message as read or unread.
	 * @param read	true if the message was read.
	 */
	public void setIsRead(Boolean read) {
		this.isRead = read;
	}
	
	/**
	 * @return	Date when message was posted.
	 */
	public long getPostDate() {
		return postDate;
	}

	/**
	 * @param postDate	Date when message was posted.
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate.getTime();
	}

}
