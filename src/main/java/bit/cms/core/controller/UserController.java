package bit.cms.core.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
        return "/WEB-INF/page/composite/index.jsp";
    }
}
