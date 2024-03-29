package bit.cms.core.controller;

import bit.cms.core.helper.Helper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 21:53
 */
public abstract class PageController implements Controller {
    private ServletRequest servletRequest;
    private ServletResponse servletResponse;

    public PageController(ServletRequest servletRequest, ServletResponse servletResponse) {
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }

    @Override
    public String getPage(Helper helper) throws ServletException, IOException {
        return getLocalPath();
    }

    protected abstract String getLocalPath();
}
