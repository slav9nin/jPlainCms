package bit.cms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static bit.cms.core.Constants.*;

/**
 * @author Artem.Telizhenko
 *         Date: 18.11.2014
 *         Time: 21:19
 */
public class DefaultServlet extends GeneralServlet {
    private static final long serialVersionUID = 7063235218767980035L;

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
        if (DEFAULT_SERVLET.equals(request.getRequestURI()))
            generalDispatch(request, response, USER_PAGE);
        else
            dispatch(request, response, EXCEPTION_SERVLET);
    }
}
