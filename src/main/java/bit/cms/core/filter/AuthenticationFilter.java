package bit.cms.core.filter;

import bit.cms.core.controller.Controller;
import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.helper.Helper;
import bit.cms.core.helper.RequestResponseHelper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static bit.cms.core.Constants.USER;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:48
 */
public class AuthenticationFilter implements Filter {

    private Filter target;

    public AuthenticationFilter() {
        this(null);
    }

    public AuthenticationFilter(Filter target) {
        this.target = target;
    }

    @Override
    public void execute(ServletRequest request, ServletResponse response) throws AuthenticationException {
        Helper helper = new RequestResponseHelper(request, response);
        Controller controller = helper.getController();
        if (helper.isAdminController(controller)) {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            HttpSession session = servletRequest.getSession(false);
            if (session == null || session.getAttribute(USER) == null)
                throw new AuthenticationException("User is not authenticated");

        }
        if (target != null)
            target.execute(request, response);
    }
}
