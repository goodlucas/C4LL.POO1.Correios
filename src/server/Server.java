package server;

import java.util.ArrayList;
import java.util.List;

import accounts.User;

public class Server {
	private List<Message> msgs;
	private String serverName;

	public Server(String serverName) {
		setServerName(serverName);
		msgs = new ArrayList<Message>();
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerName() {
		return serverName;
	}

	public static void post(Message message) {
		if (account.userExists(message.getTo()))
			TODO : send message;
		else
			System.out.println("This user doesn't exist brother.");
		
		
	}
}
