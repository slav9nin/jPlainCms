package bit.cms.core.filter;

import bit.cms.core.logger.Log;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 9:45
 */
public class MainBaseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Log.DEBUG.info(getClass().getSimpleName() + "is initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterManager filterManager = new FilterManager(filterChain);
        filterManager.processFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Log.DEBUG.info(getClass().getSimpleName() + "is destroyed");
    }
}
