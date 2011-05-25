package server;

import java.util.Date;

import accounts.User;



public class Message {
	private User from;
	private User to;
	private String text;
	private long dateSend;
	private Boolean read;


	public Message(User from, User to, String text, Boolean read) {
		this.from = from;
		this.to = to;
		this.text = text;
		this.read = read;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}
	
	public long getDateSend() {
		return dateSend;
	}

	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend.getTime();
	}

}
