package bit.cms.core.controller;

import bit.cms.core.helper.Helper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

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
    public String getPage(Helper helper) throws ServletException, IOException {
        return ERROR_PAGE;
    }

    @Override
    protected String getLocalPath() {
        return null;
    }
}
