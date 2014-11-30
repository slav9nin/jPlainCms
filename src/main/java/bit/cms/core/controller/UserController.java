package bit.cms.core.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static bit.cms.core.Constants.USER_PAGE;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 9:18
 */
public class UserController extends PageController implements Controller {

    public UserController(ServletRequest servletRequest, ServletResponse servletResponse) {
        super(servletRequest, servletResponse);
    }

    @Override
    protected String getLocalPath() {
        return USER_PAGE;
    }
}
