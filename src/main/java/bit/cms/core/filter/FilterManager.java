package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static bit.cms.core.Constants.LOGIN_SERVLET;
import static bit.cms.core.Constants.URL_PARAMETER;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 9:34
 */
public final class FilterManager implements IFilterManager {
    private javax.servlet.FilterChain chain;

    public FilterManager(javax.servlet.FilterChain chain) {
        this.chain = chain;
    }

    @Override
    public void processFilter(ServletRequest request,
                              ServletResponse response) throws ServletException, IOException {
        try {
            IFilterChain filterChain = FilterChain.getInstance();
            filterChain.processFilter(request, response);
            if (chain != null)
                chain.doFilter(request, response);
        } catch (AuthenticationException e) {
            request.setAttribute(URL_PARAMETER, ((HttpServletRequest) request).getRequestURI());
            request.getRequestDispatcher(LOGIN_SERVLET).forward(request, response);
        } catch (UserIsNotAdminException e) {
            e.printStackTrace();
        }
    }
}
