package server;



public class Message {
	private String from;
	private String to;
	private String text;
	private Boolean read;

	public Message(String from, String to, String text, Boolean read) {
		this.from = from;
		this.to = to;
		this.text = text;
		this.read = read;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
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

}
