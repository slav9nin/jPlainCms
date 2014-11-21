package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

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

    public void processFilter(ServletRequest request, ServletResponse response) throws AuthenticationException, ServletException, IOException {
        if (filter != null)
            filter.execute(request, response);
    }
}
