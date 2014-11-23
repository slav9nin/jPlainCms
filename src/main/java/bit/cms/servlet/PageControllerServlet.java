package bit.cms.servlet;

import bit.cms.core.controller.Controller;
import bit.cms.core.helper.RequestResponseHelper;
import bit.cms.core.helper.Helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 22:21
 */
public class PageControllerServlet extends GeneralServlet {
    private static final long serialVersionUID = -7217426012930131203L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Helper helper = new RequestResponseHelper(request, response);
        Controller controller = helper.getController();
        String page = controller.getPage(helper);
        generalDispatch(request, response, page);
    }
}
