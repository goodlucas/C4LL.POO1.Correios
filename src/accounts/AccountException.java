package accounts;

/**
 * Exception throwed by the Account class.
 */
@SuppressWarnings("serial")
public final class AccountException extends Exception {
    public AccountException(String message) {  
        super(message);  
    }  
}
