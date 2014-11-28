package bit.cms.core.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 21:54
 */
public class AdminController extends PageController implements Controller {
    public AdminController(ServletRequest servletRequest, ServletResponse servletResponse) {
        super(servletRequest, servletResponse);
    }

    @Override
    protected String getLocalPath() {
        return "/WEB-INF/page/admin/index.jsp";
    }
}
