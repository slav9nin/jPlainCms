package bit.cms.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static bit.cms.core.Constants.ADMIN;
import static bit.cms.core.Constants.USER;

/**
 * @author artem.telizhenko
 *         Date: 03.12.2014
 *         Time: 8:45
 */
public class ControllerFactory {

    private ControllerFactory() {
    }

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
