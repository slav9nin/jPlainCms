package bit.cms.core.helper;

import bit.cms.core.controller.AdminController;
import bit.cms.core.controller.Controller;
import bit.cms.core.controller.ErrorController;
import bit.cms.core.controller.UserController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static bit.cms.core.Constants.ADMIN;
import static bit.cms.core.Constants.USER;

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

    private static class ControllerFactory {
        public static Controller getController(HttpServletRequest request, HttpServletResponse response) {
            String path = request.getPathInfo();
            if (path == null)
                return new ErrorController(request, response);
            String[] paths = path.split("/");
            if (paths.length > 0) {
                for (String currentPath : paths) {
                    if (currentPath.length() == 0)
                        continue;
                    switch (currentPath) {
                        case USER:
                            return new UserController(request, response);
                        case ADMIN:
                            return new AdminController(request, response);
                        default:
                            return new ErrorController(request, response);
                    }
                }
            }

            return new ErrorController(request, response);
        }
    }
}
