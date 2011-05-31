package accounts;

import java.util.Date;

import server.ServerException;
import util.DateString;


/**
 * Message information. It will store information about from where and to whom
 * the message is, the content, the post date, and if the message was read.
 * When a message is sent to the server, the server will dispatch a copy, copy
 * got calling the clone event, to each account get its very message. This 
 * allows to each account mark a message as read, and set an id without conflits
 * to another accounts.
 */
public class Message implements Cloneable {
	/**
	 * Message id. The id is the identification of the message in an account.
	 */
	private int	messageId = 0;	
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
	private Date		postDate;
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
	public Date getPostDate() {
		return postDate;
	}

	/**
	 * @param postDate	Date when message was posted.
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	/**
	 * @return	The date the message was received.
	 */
	private String getPostDateString() {
		return DateString.DateToString(getPostDate());
	}
	
	/**
	 * @return	Elapsed time since the message was received.
	 */
	private String getPostDateElapsedTime() {
		return DateString.elapsedTime(getPostDate(), new Date());
	}

	/**
	 * @return Account message identification. Zero when not defined.
	 */
	public int getMessageId() {
		return messageId;
	}
	
	/**
	 * Set an ID to the message. This is known as the index of a message
	 * in one account. If never called, the default message id is zero. 
	 * @param id	New message ID.
	 */
	public void setMessageId(int id) {
		messageId = id;
	}
	
	/**
	 * Construct a string with message header.
	 *  %id - %from - %subject - %date - [%read] 
	 */
	public String toStringHeader() {
		return "\t" + getMessageId() + " - " + getFrom() + " - " + getSubject() 
				+ " - "	+ getPostDateString() + " - "
				+ "[" + (getIsRead()? "lida": "não lida") + "]";
	}

	/**
	 * Convert the message to user readily.
	 */
	@Override
	public String toString() {
		return "\tDe: " + getFrom() + "\n\t" +
				"Para: " + getDestinations().toString() + "\n\t" + 
				"Assunto: " + getSubject() + "\n\t" + 
				"Recebimento: " + getPostDateString() + "\n\t" +
				"Tempo Decorrido: " + getPostDateElapsedTime() + "\n\t" + 
				"Conteúdo: \n\t" + getContent() + "\n"; 
	}
	
	/**
	 * Clone the instance to another message. This method is called when the
	 * same message is sent to more than one user, then each user receives
	 * its very own message instance. If clone fails, the received parameter
	 * will be returned without return any errors.
	 */
	public Message clone() {
		try {
			return (Message) super.clone();
		} catch (CloneNotSupportedException e) {
			return this;
		}
	}
}
