package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 9:34
 */
public class FilterManager {
    public void processFilter(ServletRequest request,
                              ServletResponse response) throws AuthenticationException, ServletException, IOException {
        FilterChain filterChain = new FilterChain();
        filterChain.processFilter(request, response);
    }
}
