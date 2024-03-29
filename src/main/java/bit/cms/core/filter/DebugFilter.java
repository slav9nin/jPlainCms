package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;
import bit.cms.core.logger.Log;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:49
 */
public class DebugFilter implements Filter {
    private static final long serialVersionUID = 4373127765482008548L;

    private Filter target;

    public DebugFilter(Filter target) {
        this.target = target;
    }

    @Override
    public void execute(final ServletRequest request, ServletResponse response)
            throws AuthenticationException, UserIsNotAdminException {
        Log.DEBUG.info("Page is: " + ((HttpServletRequest) request).getRequestURI());

        if (target != null)
            target.execute(request, response);
    }
}
