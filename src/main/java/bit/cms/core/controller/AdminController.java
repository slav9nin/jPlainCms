package bit.cms.core.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static bit.cms.core.Constants.ADMIN_INDEX_PAGE;

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
        return ADMIN_INDEX_PAGE;
    }
}
