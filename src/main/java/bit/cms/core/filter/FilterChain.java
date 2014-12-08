package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static bit.cms.core.Constants.SIGN_SERVLET;
import static bit.cms.core.Constants.STATIC_PATH;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:50
 */
public final class FilterChain implements IFilterChain {
    private static IFilterChain instance = new FilterChain();

    public static IFilterChain getInstance() {
        return instance;
    }

    @Override
    public void processFilter(ServletRequest request, ServletResponse response)
            throws AuthenticationException, ServletException, IOException, UserIsNotAdminException {
        String path = ((HttpServletRequest) request).getRequestURI();
        if (path.startsWith(STATIC_PATH) || path.equals(SIGN_SERVLET))
            return;
        if (DEFAULT_FILTER != null)
            DEFAULT_FILTER.execute(request, response);
    }
}
