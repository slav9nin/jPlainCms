package bit.cms.core.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static bit.cms.core.Constants.ERROR_PAGE;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 9:28
 */
public class ErrorController extends PageController implements Controller {
    public ErrorController(ServletRequest servletRequest, ServletResponse servletResponse) {
        super(servletRequest, servletResponse);
    }

    @Override
    protected String getLocalPath() {
        return ERROR_PAGE;
    }
}
