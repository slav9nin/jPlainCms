package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

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
public class FilterChain {
    private Filter filter;

    public FilterChain() {
        filter = new DebugFilter(new AuthenticationFilter(new CoreFilter()));
    }

    public FilterChain(Filter filter) {
        this.filter = filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void processFilter(ServletRequest request, ServletResponse response) throws AuthenticationException, ServletException, IOException {
        String path = ((HttpServletRequest) request).getRequestURI();
        if (path.startsWith(STATIC_PATH) || path.equals(SIGN_SERVLET))
            return;
        if (filter != null)
            filter.execute(request, response);
    }
}
