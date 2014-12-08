package bit.cms.core.exception;

/**
 * Created by bito4ek on 08.12.14.
 */
public class PageNotFoundException extends Exception {
    private static final long serialVersionUID = 7990516714112801435L;

    public PageNotFoundException() {
        super();
    }

    public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
