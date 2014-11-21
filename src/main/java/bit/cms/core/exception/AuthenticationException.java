package bit.cms.core.exception;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 10:22
 */
public class AuthenticationException extends Exception {
    private static final long serialVersionUID = -4524852439078949987L;

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    protected AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
