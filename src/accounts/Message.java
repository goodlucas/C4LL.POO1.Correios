package accounts;

import java.util.Date;

import server.ServerException;


/**
 * Message information. It will store information about from where and to whom
 * the message is, the content, the post date, and if the message was read.
 */
public class Message {
	/**
	 * Message id. The id is the identification of the message in an account.
	 */
	private int			messageId;
	/**
	 * Sender user's login name.
	 */
	private String		from;
	/**
	 * Destination users' login names. A message can have one or more
	 * destination.
	 */
	private DestinationList	to;
	/**
	 * Message subject.
	 */
	private String		subject;
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
	public Message(String from, String to, String subject, String content, 
			Boolean read) throws ServerException {
		this.to = new DestinationList();
		if (to != null)
			this.addDestination(to);
		setFrom(from);
		setContent(content);
		setIsRead(read);
		setSubject(subject);
		setMessageId(0);
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
	public DestinationList getDestinations() {
		return to;
	}

	/**
	 * Add a message destination.
	 * @param loginName	Destination login name.
	 * @throws ServerException	When the login is already as a destination.
	 */
	public void addDestination(String loginName) throws ServerException {
		if (to.contains(loginName))
			throw new ServerException("Destino duplicado (" + loginName + ")");
		this.to.add(loginName);
	}
	
	/**
	 * Add various destinations to the message.
	 * @param list	Destination list.
	 * @throws ServerException	Duplicate user.
	 */
	public void addDestinations(DestinationList list) throws ServerException {
		for (String dest: list)
			addDestination(dest);
	}

	/**
	 * @return	the new message subject. 
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return	the message subject. 
	 */
	public String getSubject() {
		return subject;
	}	

	/**
	 * @return	the text message. 
	 */
	public String getContent() {
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

	/**
	 * Set message identification for an account.
	 * @param messageId	The new message id.
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return Account message identification. Zero when not defined.
	 */
	public int getMessageId() {
		return messageId;
	}
	
	/**
	 * Construct a string with message header.
	 *  %id - %from - %subject - %date - [%read] 
	 */
	public String toStringHeader() {
		return "\t" + getMessageId() + " - " + getFrom() + " - " + getSubject() 
				+ " - "	+ getPostDate() + " - "
				+ "[" + (getIsRead()? "lida": "não lida") + "]";
	}

	/**
	 * Convert the message to user readily.
	 */
	@Override
	public String toString() {
		return "\tDe: " + this.getFrom() + "\n\t" +
				"Para: " + this.getDestinations().toString() + "\n\t" + 
				"Assunto: " + this.getSubject() + "\n\t" + 
				"Recebimento: " + "\n\t" + // TODO : post date.
				"Tempo Decorrido: " + "\n\t" + // TODO : date diff
				"Conteúdo: \n\t" + this.getContent() + "\n"; 
	}
}
