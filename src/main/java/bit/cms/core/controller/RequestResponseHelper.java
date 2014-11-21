package bit.cms.core.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 8:47
 */
public class RequestResponseHelper {
    private ServletRequest servletRequest;
    private ServletResponse servletResponse;

    public RequestResponseHelper(ServletRequest servletRequest, ServletResponse servletResponse) {
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }

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
