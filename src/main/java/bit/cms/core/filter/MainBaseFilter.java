package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.FilterChain;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 9:45
 */
public class MainBaseFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.startsWith("/static") || path.equals("/sign")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            FilterManager filterManager = new FilterManager();
            try {
                filterManager.processFilter(servletRequest, servletResponse);
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (AuthenticationException e) {
                servletRequest.setAttribute("url", ((HttpServletRequest) servletRequest).getRequestURI());
                servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
