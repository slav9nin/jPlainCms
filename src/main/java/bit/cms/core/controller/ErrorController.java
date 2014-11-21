package bit.cms.core.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

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
    public String getPage(RequestResponseHelper helper) throws ServletException, IOException {
        return "/WEB-INF/page/error.jsp"; //some error page
    }

    @Override
    public String getLocalPath() {
        return null;
    }
}
