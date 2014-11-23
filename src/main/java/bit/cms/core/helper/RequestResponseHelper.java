package bit.cms.core.helper;

import bit.cms.core.controller.AdminController;
import bit.cms.core.controller.Controller;
import bit.cms.core.controller.ErrorController;
import bit.cms.core.controller.UserController;

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

    private static class ControllerFactory {
        public static Controller getController(HttpServletRequest request, HttpServletResponse response) {
//            String requestUri = request.getRequestURI();
            String path = request.getPathInfo();
            if (path == null)
                return new ErrorController(request, response);
            String[] paths = path.split("/");
            if (paths.length > 0) {
                for (String currentPath : paths) {
                    if (currentPath.length() == 0)
                        continue;
                    switch (currentPath) {
                        case Controller.USER:
                            return new UserController(request, response);
                        case Controller.ADMIN:
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
