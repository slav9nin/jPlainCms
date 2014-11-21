package bit.cms.core.exception;

/**
 * @author Artem.Telizhenko
 *         Date: 14.11.2014
 *         Time: 9:24
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 6689775871806779661L;

    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
