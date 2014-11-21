package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:48
 */
public class AuthenticationFilter implements Filter {

    private Filter target;

    public AuthenticationFilter(Filter target) {
        this.target = target;
    }

    @Override
    public void execute(ServletRequest request, ServletResponse response) throws AuthenticationException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        HttpSession session = servletRequest.getSession(false);
        if (session == null || session.getAttribute("user") == null)
            throw new AuthenticationException("User is not authenticated");

        if (target != null)
            target.execute(request, response);
    }
}
