package server;

/**
 * Exception throwed by the Server class.
 */
@SuppressWarnings("serial")
public final class ServerException extends Exception {
    public ServerException(String message) {  
        super(message);  
    }  
}
