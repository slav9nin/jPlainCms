package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 9:34
 */
public class FilterManager {
    private javax.servlet.FilterChain chain;

    public FilterManager(javax.servlet.FilterChain chain) {
        this.chain = chain;
    }

    public void processFilter(ServletRequest request,
                              ServletResponse response) throws ServletException, IOException {
        try {
            FilterChain filterChain = new FilterChain();
            filterChain.processFilter(request, response);
            chain.doFilter(request, response);
        } catch (AuthenticationException e) {
            request.setAttribute("url", ((HttpServletRequest) request).getRequestURI());
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}
