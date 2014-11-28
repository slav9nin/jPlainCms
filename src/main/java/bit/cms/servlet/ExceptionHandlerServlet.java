package bit.cms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 18.11.2014
 *         Time: 20:33
 */
public class ExceptionHandlerServlet extends GeneralServlet {
    private static final long serialVersionUID = -8221190921141462472L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generalDispatch(request, response, "/WEB-INF/page/composite/error.jsp");
    }
}
