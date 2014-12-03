package bit.cms.core.helper;

import bit.cms.core.controller.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 8:47
 */
public class RequestResponseHelper implements Helper {
    private static final long serialVersionUID = 3435265598340082299L;

    private ServletRequest servletRequest;
    private ServletResponse servletResponse;

    public RequestResponseHelper(ServletRequest servletRequest, ServletResponse servletResponse) {
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }

    @Override
    public Controller getController() {
        return ControllerFactory.getController((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
    }

    @Override
    public boolean isAdminController(Controller controller) {
        return controller != null && controller instanceof AdminController;
    }

    @Override
    public boolean isAUserController(Controller controller) {
        return controller != null && controller instanceof UserController;
    }

    @Override
    public boolean isErrorController(Controller controller) {
        return controller != null && controller instanceof ErrorController;
    }
}
