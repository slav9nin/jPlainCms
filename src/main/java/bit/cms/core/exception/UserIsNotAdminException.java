package bit.cms.core.exception;

/**
 * Created by bito4ek on 08.12.14.
 */
public class UserIsNotAdminException extends Exception {
    private static final long serialVersionUID = -3299970164125807021L;

    public UserIsNotAdminException() {
        super();
    }

    public UserIsNotAdminException(String message) {
        super(message);
    }

    public UserIsNotAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotAdminException(Throwable cause) {
        super(cause);
    }

    protected UserIsNotAdminException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
