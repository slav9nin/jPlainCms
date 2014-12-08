package bit.cms.core.filter;

import bit.cms.bean.ParameterBean;
import bit.cms.core.controller.Controller;
import bit.cms.core.dao.domain.User;
import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;
import bit.cms.core.helper.Helper;
import bit.cms.core.helper.RequestResponseHelper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicReference;

import static bit.cms.core.Constants.USER;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:48
 */
public class AuthenticationFilter implements Filter {
    private static final long serialVersionUID = 5230344241970344845L;

    private final AtomicReference<Filter> target = new AtomicReference<>();

    public AuthenticationFilter(Filter target) {
        this.target.set(target);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void execute(ServletRequest request, ServletResponse response)
            throws AuthenticationException, UserIsNotAdminException {
        Helper helper = new RequestResponseHelper(request, response);
        Controller controller = helper.getController();
        if (helper.isAdminController(controller)) {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            HttpSession session = servletRequest.getSession(false);
            if (session == null || session.getAttribute(USER) == null)
                throw new AuthenticationException("User is not authenticated");
            else if (session.getAttribute(USER) != null) {
                ParameterBean<User> bean = (ParameterBean<User>) session.getAttribute(USER);
                User currentUser = bean.getParameterValue();
                if (!currentUser.getUserRole().isAdmin())
                    throw new UserIsNotAdminException("User + " + currentUser.getLogin() + " is not an Administrator");
            }

        }
        if (target.get() != null)
            target.get().execute(request, response);
    }
}
